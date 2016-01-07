package org.java.learn.topic.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * ClassName: SimpleDateFormatTest <br/>
 * Description: TODO <br/>
 * Date: 2016-01-05 16:05 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-01-05 jdai@ created. <br/>
 */
public class SimpleDateFormatTest {

    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();

    public static void main(String[] args) throws InterruptedException {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S");

        final String[] dateStrings = {
                "2014-04-30 18:51:01,61",
                "2014-04-30 18:51:01,461",
                "2014-04-30 18:51:01,361",
                "2014-04-30 18:51:01,261",
                "2014-04-30 18:51:01,161",
        };
        int threadNum = 5;
        Thread[] parseThreads = new Thread[threadNum];
        for (int i=0; i<threadNum; i++) {
            parseThreads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j=0; j<dateStrings.length; j++) {
                        try {
                            printWithThreadLocal(sdf,dateStrings[j]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            parseThreads[i].start();
        }

        for (int i=0; i<threadNum; i++) {
            parseThreads[i].join();
        }
    }

    static void print(SimpleDateFormat sdf,String date) throws ParseException {
        System.out.println(Thread.currentThread().getName() + " " + sdf.parse(date));
    }

    static synchronized void  printWithSynchronized(SimpleDateFormat sdf,String date) throws ParseException {
        System.out.println(Thread.currentThread().getName() + " " + sdf.parse(date));
    }

    static void printWithThreadLocal(SimpleDateFormat sdf,String date) throws ParseException {
        sdf = threadLocal.get();
        if (threadLocal.get() == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S");
            threadLocal.set(sdf);
        }
        System.out.println(Thread.currentThread().getName() + " " + sdf.parse(date));
    }


}
