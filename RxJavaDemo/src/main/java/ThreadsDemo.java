import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by daijiajia on 16/9/8.
 */
public class ThreadsDemo {


    public static void main(String[] args) {

        final Integer sum = 0;

        Observable.range(0, 100).flatMap(new Func1<Integer, Observable<?>>() {
            @Override
            public Observable<?> call(Integer integer) {
                return Observable.create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        subscriber.onNext(integer);
                        subscriber.onCompleted();
                    }
                });
            }
        }).subscribe(i -> System.out.println(i));


    }

}
