package org.shekhar.xke.frp.introtorx.creational;

import rx.Observable;

public class RangeExample {

    public static void main(String[] args) {
        Observable<Integer> rangeObservable = Observable.range(2, 5);
        rangeObservable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }
}
