import org.apache.commons.httpclient.util.HttpURLConnection;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by daijiajia on 16/8/13.
 */
public class RxJavaDemo {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        testRxJavaWithoutBlocking(1);
        testRxJavaWithBlocking(1);
    }

    public static void testRxJavaWithoutBlocking(int count) throws InterruptedException {

        final CountDownLatch finished = new CountDownLatch(1);

        long start = System.nanoTime();
        Observable.range(0, count).map(i -> {
            return 200;
        }).subscribe(
                statusCode -> {
                },
                error -> {
                },
                () -> {
                    finished.countDown();
                });

        finished.await();


        System.out.println("RxJavaWithoutBlocking TPS:" + count * 1000000000 / (System.nanoTime() - start));
    }

    public static void testRxJavaWithBlocking(int count) throws InterruptedException, MalformedURLException {

        final CountDownLatch finished = new CountDownLatch(1);
        URL url = new URL("http://www.baidu.com/");

        long start = System.nanoTime();
        Observable.range(0, count).map(i -> {

            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while (in.readLine() != null) {

                }
                return responseCode;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return 200;
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).subscribe(
                statusCode -> {
                },
                error -> {
                },
                () -> {
                    finished.countDown();
                });

        finished.await();


        System.out.println("RxJavaWithBlocking TPS:" + count * 1000000000 / (System.nanoTime() - start));
    }


    public static void testRxJavaWithFlatMap(int count) throws MalformedURLException, InterruptedException {

        final CountDownLatch finished = new CountDownLatch(1);

        ExecutorService executor = Executors.newFixedThreadPool(200);
        URL url = new URL("http://www.baidu.com/");

        long start = System.nanoTime();
        Observable.range(0, count).subscribeOn(Schedulers.io()).flatMap(i -> {

            return Observable.just(i).subscribeOn(Schedulers.from(executor)).map(v -> {
                try {
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    int responseCode = conn.getResponseCode();
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        //response.append(inputLine);
                    }
                    in.close();
                    return responseCode;
                } catch (Exception ex) {
                    return -1;
                }
            });

        }).observeOn(Schedulers.computation()).subscribe(
                statusCode -> {
                },
                error -> {
                },
                () -> {
                    finished.countDown();
                }
        );

        finished.await();

        System.out.println("RxJavaWithFlatMap TPS:" + count * 1000000000 / (System.nanoTime() - start));

    }

}
