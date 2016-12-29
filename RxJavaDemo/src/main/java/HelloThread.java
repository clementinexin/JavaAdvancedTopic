import org.apache.commons.httpclient.util.HttpURLConnection;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.io.IOException;
import java.net.URL;

/**
 * Created by daijiajia on 16/8/14.
 */
public class HelloThread {

    public static void main(String[] args) {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("Observable on Thread -> " + Thread.currentThread().getName());
                subscriber.onNext("MultiThreading");
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(s -> {
                    System.out.println("Subscriber on Thread -> " + Thread.currentThread().getName());
                });

        Observable.just("http://www.baidu.com")
                .map(url -> {
                    System.out.println(Thread.currentThread());
                    try {
                        HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
                        connection.setRequestMethod("GET");
                        int res = connection.getResponseCode();
                        System.out.println(res);
                        return res;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return -1;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(code -> {
                    System.out.println(Thread.currentThread());
                    System.out.print(code);
                });


    }
}
