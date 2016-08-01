package org.java.learn.topic.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by daijiajia on 16/8/1.
 */
public class ConcurrentModificationExceptionWhenAdd {
    public static void main(String[] args) {
//        Map<Long, Long> map = new ConcurrentHashMap<Long, Long>();
        List<Long> list = new ArrayList<Long>();
//        List<Long> list = new CopyOnWriteArrayList<Long>();
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        AtomicLong count = new AtomicLong(0);

        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new PutTask(list, count, rwLock));
            t1.start();
            Thread t2 = new Thread(new PollTask(count, list, rwLock));
            t2.start();
        }
    }

    static class PutTask implements Runnable {
        private List list;
        private AtomicLong count;
        private ReadWriteLock lock;

        public PutTask(List list, AtomicLong count, ReadWriteLock lock) {
            this.list = list;
            this.count = count;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.writeLock().lock();
                    list.add(count.getAndIncrement());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.writeLock().unlock();
                }

            }
        }
    }

    static class PollTask implements Runnable {

        private List list;
        private AtomicLong count;
        private ReadWriteLock lock;


        public PollTask(AtomicLong count, List list, ReadWriteLock lock) {
            this.count = count;
            this.list = list;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                lock.readLock().lock();
                try {
                    for (Object l : list) {
                        System.out.println((Long) l);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.readLock().unlock();
                }

            }
        }
    }
}
