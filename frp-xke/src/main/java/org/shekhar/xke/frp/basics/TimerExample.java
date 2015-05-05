package org.shekhar.xke.frp.basics;

import rx.Observable;
import rx.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class TimerExample {

    public static void main(String[] args) throws Exception{
        ConnectableObservable<Long> timer = Observable.timer(0, 1, TimeUnit.SECONDS).publish();
        timer.connect();
        timer.subscribe(x -> System.out.println(">> "+x));

        Thread.sleep(2000);

        timer.subscribe(x -> System.out.println("++ "+x));

        Thread.sleep(50000);

    }
}
