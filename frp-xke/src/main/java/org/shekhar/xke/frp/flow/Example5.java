package org.shekhar.xke.frp.flow;

import rx.Observable;

public class Example5 {
    public static void main(String[] args) {
        Observable<String> observable = Observable.<String>create(subscriber -> subscriber.onNext("Hello world"));

        observable.subscribe(System.out::println);

    }
}
