package org.shekhar.xke.frp.basics;

import rx.Observable;

import java.util.UUID;

public class XebiansRx {

    public static void main(String[] args) {
        XebiansObservable xebians = new XebiansObservable();
        xebians.take(5).subscribe(System.out::println);
    }
}

class XebiansObservable extends Observable<String> {

    public XebiansObservable() {
        super(subscriber -> {
            while (!subscriber.isUnsubscribed()) {
                subscriber.onNext(UUID.randomUUID().toString());
            }
        });
    }
}