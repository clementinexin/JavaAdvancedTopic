import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

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
        

    }
}
