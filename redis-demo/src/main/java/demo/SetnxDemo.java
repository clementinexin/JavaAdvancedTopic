package demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Date;

/**
 * Created by daijiajia on 16/5/12.
 */
public class SetnxDemo {


    public static final long LOCK_TIMEOUT = 100l;

    public static final String LOCK_KEY = "LOCK_KEY";

    public static long lock = 0;

    public static long next = 0;

//    public static Jedis client;

    public static int sum = 0;

    public static JedisPool pool;

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(60000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);

        pool = new JedisPool(config, "127.0.0.1", 6379);
//        client = pool.getResource();

        int threadNum = 100;

        Thread self = new Thread(new Runnable() {
            @Override
            public void run() {
                Jedis client = pool.getResource();

                if (acquireLock(client)) {
                    System.out.println(Thread.currentThread().getName() + " *** acquire the lock @ " + new Date().getTime());
//                    sum++;
//                    throw new Exception("exception thrown by self");
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
                Thread.currentThread().stop();
                sum++;
                System.out.println(Thread.currentThread().getName() + " *** release the lock @ " + new Date().getTime());
                releaseLock(client);


            }
        });

        self.start();
//        self.interrupt();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    Jedis client = pool.getResource();

                    if (acquireLock(client)) {
                        System.out.println(Thread.currentThread().getName() + " acquire the lock @ " + new Date().getTime());
                        sum++;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " release the lock @ " + new Date().getTime());
                    releaseLock(client);


                    /*
                    Jedis client = pool.getResource();
                    if (acquireLock(client, LOCK_KEY)) {
                        System.out.println(Thread.currentThread().getName() + " acquire the lock @ " + new Date().getTime());

                        sum++;
                    }

                    System.out.println(Thread.currentThread().getName() + " release the lock @ " + new Date().getTime());

                    releaseLock(client, LOCK_KEY);
                    */

                }
            });
            thread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sum : " + sum);
    }

    public static boolean acquireLock(Jedis jedis, String lock) {
        // 1. 通过SETNX试图获取一个lock
        boolean success = false;
//        Jedis jedis = pool.getResource();
        long value = System.currentTimeMillis() + LOCK_TIMEOUT + 1;
        long acquired = jedis.setnx(lock, String.valueOf(value));
        //SETNX成功，则成功获取一个锁
        if (acquired == 1)
            success = true;
            //SETNX失败，说明锁仍然被其他对象保持，检查其是否已经超时
        else {
            long oldValue = Long.valueOf(jedis.get(lock));

            //超时
            if (oldValue < System.currentTimeMillis()) {
                String getValue = jedis.getSet(lock, String.valueOf(value));
                // 获取锁成功
                if (Long.valueOf(getValue) == oldValue)
                    success = true;
                    // 已被其他进程捷足先登了
                else
                    success = false;
            }
            //未超时，则直接返回失败
            else
                success = false;
        }
//        pool.returnResource(jedis);
        return success;
    }

    //释放锁
    public static void releaseLock(Jedis jedis, String lock) {
//        Jedis jedis = pool.getResource();
        long current = System.currentTimeMillis();
        // 避免删除非自己获取得到的锁
        if (current < Long.valueOf(jedis.get(lock))) {

            jedis.del(lock);
            jedis.close();
        }
//        pool.returnResource(jedis);
    }


    public static boolean acquireLock(Jedis client) {

        while (true) {
            long now = new Date().getTime();
            next = now + LOCK_TIMEOUT;
            lock = client.setnx(LOCK_KEY, next + "");
            String value = null;
            if (lock == 1) return true;

            if ((value = client.get(LOCK_KEY)) != null && now > Long.parseLong(value)
                    && (now > Long.parseLong(client.getSet(LOCK_KEY, next + "")))) {
                return true;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void releaseLock(Jedis client) {
        Date now = new Date();
        if (now.getTime() < Long.parseLong(client.get(LOCK_KEY))) {
            client.del(LOCK_KEY);
            client.close();
        }
    }

}
