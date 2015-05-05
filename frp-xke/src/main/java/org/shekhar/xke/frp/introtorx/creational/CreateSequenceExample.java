package org.shekhar.xke.frp.introtorx.creational;

import rx.Observable;

public class CreateSequenceExample {

    public static void main(String[] args) {
        Observable<String> observable = Observable.<String>create(subscriber -> subscriber.onNext("Hello World"));
        observable.subscribe(str -> System.out.println(String.format("first {%s}", str)));
        observable.subscribe(str -> System.out.println(String.format("second {%s}", str)));
        observable.subscribe(str -> System.out.println(String.format("third {%s}", str)));
        observable.subscribe(str -> System.out.println(String.format("fourth {%s}", str)));
        observable.subscribe(str -> System.out.println(String.format("fifth {%s}", str)));
    }

    public static <T> Observable<T> empty() {
        return Observable.<T>create(subscriber -> subscriber.onCompleted());
    }


    public static <T> Observable<T> returnObs(T t) {
        return Observable.<T>create(sub -> {
            sub.onNext(t);
            sub.onCompleted();
        });
    }

    public static <T> Observable<T> never(){
        return Observable.create(sub -> {
        });
    }

    public static <T> Observable<T> error(Throwable t){
        return Observable.create(sub -> sub.onError(t));
    }

}
