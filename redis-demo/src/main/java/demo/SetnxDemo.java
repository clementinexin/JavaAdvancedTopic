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
