package org.shekhar.xke.frp.introtorx;


import rx.Observable;
import rx.Subscriber;

import java.util.UUID;

public class Example1 {

    public static void main(String[] args) {
        Observable<String> observable = Observable.create(subscriber -> {
            while (!subscriber.isUnsubscribed()) subscriber.onNext(UUID.randomUUID().toString());
        });

        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Sequence successfully terminated..");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(String.format("Exception : {%s}", e));
            }

            @Override
            public void onNext(String s) {
                System.out.println(String.format("value {%s}", s));
            }
        });


    }
}
