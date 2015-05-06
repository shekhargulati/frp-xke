package org.shekhar.xke.frp.introtorx.inspection;

import rx.Observable;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AllExample {


    public static void main(String[] args) {
        Observable<Integer> numbers = Observable.from(IntStream.range(1, 20).boxed().collect(toList()));
        numbers.subscribe(System.out::println);
        numbers.all(number -> number < 20).subscribe(number -> System.out.println(number));
    }
}
