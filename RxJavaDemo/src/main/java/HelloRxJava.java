import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by daijiajia on 16/8/14.
 */
public class HelloRxJava {


    public static void main(String[] args) {
        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        myObservable.subscribe(mySubscriber);

        Observable<String> observable2 = Observable.just("Hello");
        observable2.subscribe(mySubscriber);

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };

        myObservable.subscribe(onNextAction);

        Observable.just("Hello").subscribe(s -> {
            System.out.println(s);
        });


        Observable.just("Hello").subscribe(s -> {
            System.out.println(s + " RxJava");
        });

        Observable.just("Hello").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + " RxJava";
            }
        }).subscribe(s -> {
            System.out.println(s);
        });

        Observable.just("Hello").map(s -> s + " RxJava").subscribe(s -> System.out.println(s));
    }
}
