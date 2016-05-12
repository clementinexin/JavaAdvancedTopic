package thread;

/**
 * Created by daijiajia on 16/5/12.
 */
public class ThreadInterruptTest {

    static private volatile boolean wakeupBySelf = false;

    final static private Object monitor = new Object();

    public static void main(String[] args) {
        final Thread roundRobbin = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Wait 10s");
                        monitor.wait(10000);
                    } catch (InterruptedException e) {
                        if (wakeupBySelf) {
                            System.out.println(Thread.currentThread().getName() + " wake up by self ");
                        } else {
                            System.out.println(Thread.currentThread().getName() + " wake up by others");
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " Exited");
                }
            }
        });

        Thread wakeup = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " sleep 5s");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
                synchronized (monitor) {
                    wakeupBySelf = true;
                    System.out.println(Thread.currentThread().getName() + " wake up " + roundRobbin.getName());
                    monitor.notify();
                }
            }
        });

        roundRobbin.start();
        wakeup.start();

    }
}
