package org.shekhar.xke.frp.flow;

import java.util.stream.IntStream;

public class Example3 {

    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach(System.out::println);
    }
}
