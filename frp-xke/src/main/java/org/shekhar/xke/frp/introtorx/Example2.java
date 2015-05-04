package org.shekhar.xke.frp.introtorx;

import rx.Subscription;
import rx.subjects.ReplaySubject;

import java.util.UUID;

public class Example2 {

    public static void main(String[] args) {
        ReplaySubject<String> subject = ReplaySubject.createWithSize(2);
        subject.onNext(UUID.randomUUID().toString());
        subject.onNext(UUID.randomUUID().toString());
        subject.onNext(UUID.randomUUID().toString());
        subject.onNext(UUID.randomUUID().toString());
        subject.onNext(UUID.randomUUID().toString());
        Subscription subscription = subject.subscribe(str -> System.out.println(String.format("value {%s} , Thread {%s}", str, Thread.currentThread().getName())));
        subject.onNext(UUID.randomUUID().toString());
        subject.onNext(UUID.randomUUID().toString());
        subject.onNext(UUID.randomUUID().toString());
        subject.onNext(UUID.randomUUID().toString());
        subject.onCompleted();
    }
}
