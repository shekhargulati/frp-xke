package org.shekhar.xke.frp.java8;

import java.util.stream.IntStream;

public class StreamsExample {

    public static void main(String[] args) {
        System.out.println("******************************************");
        IntStream.rangeClosed(1, 10).map(num -> num + 10).forEach(System.out::println);
        System.out.println("******************************************");
        IntStream.rangeClosed(1, 10).filter(num -> num % 2 == 0).forEach(System.out::println);
        System.out.println("******************************************");
        IntStream.rangeClosed(1, 10).map(num -> num + 10).filter(num -> num % 2 == 0). forEach(System.out::println);
        System.out.println("******************************************");
        System.out.println(IntStream.rangeClosed(1, 10).sum());
        System.out.println("******************************************");
        IntStream.rangeClosed(1, 100).skip(50).limit(10).forEach(System.out::println);
        System.out.println("******************************************");



    }
}
