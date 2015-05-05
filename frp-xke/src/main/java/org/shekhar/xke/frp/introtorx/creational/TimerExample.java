package org.shekhar.xke.frp.introtorx.creational;

import rx.Observable;
import rx.Subscription;

import java.util.concurrent.TimeUnit;

public class TimerExample {

    public static void main(String[] args) throws Exception {
        Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);
        Subscription subscription = intervalObservable.subscribe(val -> System.out.println(String.format("first %d", val)));

        Thread.sleep(3000);

        subscription.unsubscribe();

        Observable<Long> timerObservable = Observable.timer(1, 1, TimeUnit.SECONDS);
        timerObservable.subscribe(val -> System.out.println(String.format("second %d", val)));

        Thread.sleep(3000);

    }
}
