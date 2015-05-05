package org.shekhar.xke.frp.java8;

import java.util.stream.IntStream;

public class InfiniteNaturalNumber {

    public static void main(String[] args) {
        IntStream.iterate(1, value -> value + 1).limit(100).forEach(System.out::println);
    }
}
