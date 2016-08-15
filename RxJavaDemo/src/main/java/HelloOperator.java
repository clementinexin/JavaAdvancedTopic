import rx.Observable;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by daijiajia on 16/8/14.
 */
public class HelloOperator {

    static Observable<List<String>> query(String text) {
        if (text.equals("Hello"))
            return Observable.just(Arrays.asList("Hello RxJava", "Hello world"));
        else
            return null;
    }

    static Observable<String> getTitle(String text) {
        if (text.equals("Hello RxJava")) {
            return Observable.just("Hello RxJava Title");
        }
        if (text.equals("Hello world")) {
            return Observable.just("Hello world Title");
        }
        return null;
    }

    static Observable<String> saveTitle(String text) {
        System.out.println("save title to disk");
        return Observable.just(text);
    }

    public static void main(String[] args) {

        query("Hello").subscribe(urls -> {
            for (String url :
                    urls) {
                System.out.println(url);
            }
        });

        query("Hello")
                .subscribe(urls -> Observable.from(urls)
                        .subscribe(url -> System.out.println(url)));

        query("Hello")
                .flatMap(new Func1<List<String>, Observable<?>>() {
                    @Override
                    public Observable<?> call(List<String> strings) {
                        return Observable.from(strings);
                    }
                })
                .subscribe(url -> System.out.println(url));

        query("Hello")
                .flatMap(urls -> Observable.from(urls))
                .subscribe(url -> System.out.println(url));

        query("Hello")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(new Func1<String, Observable<?>>() {
                    @Override
                    public Observable<?> call(String s) {
                        return getTitle(s);
                    }
                })
                .subscribe(title -> System.out.println(title));

        query("Hello")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .subscribe(title -> System.out.println(title));


        query("Hello")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .filter(title -> title != null)
                .take(1)
                .doOnNext(title -> saveTitle(title))
                .subscribe(title -> System.out.println(title));
    }
}
