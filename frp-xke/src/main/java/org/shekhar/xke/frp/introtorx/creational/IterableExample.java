package org.shekhar.xke.frp.introtorx.creational;

import rx.Observable;

import java.util.Arrays;

public class IterableExample {

    public static void main(String[] args) {
        Observable<String> xl = Observable.from(Arrays.asList("shekhar", "sameer", "aditya", "ankur"));
        xl.map(name -> name.toUpperCase()).filter(name -> name.startsWith("A")).subscribe(System.out::println);
    }
}
