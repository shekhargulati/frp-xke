package org.shekhar.xke.frp.introtorx.filter;

import rx.Observable;
import rx.functions.Action1;

import java.util.UUID;

public class FilterExample {

    public static void main(String[] args) {
        Observable<String> uuidGenerator = Observable.<String>create(subscriber -> {
            subscriber.onNext(UUID.randomUUID().toString());
            subscriber.onNext(UUID.randomUUID().toString());
            subscriber.onNext(UUID.randomUUID().toString());

        });

        Action1<String> first = str -> System.out.println("first got " + str);
        Action1<String> second = str -> System.out.println("second got " + str);
        Action1<String> third = str -> System.out.println("third got " + str);
        uuidGenerator.subscribe(first);
        uuidGenerator.subscribe(second);
        uuidGenerator.subscribe(third);
    }
}
