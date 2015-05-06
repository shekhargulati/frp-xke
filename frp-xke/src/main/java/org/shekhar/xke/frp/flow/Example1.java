package org.shekhar.xke.frp.flow;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that generates a sequence of positive natural numbers (http://en.wikipedia.org/wiki/Natural_number)
 */
public class Example1 {

    public static void main(String[] args) {
        List<Long> naturalNumbers = naturalNumbers(100);
        for (Long naturalNumber : naturalNumbers) {
            System.out.println(naturalNumber);
        }
    }

    public static List<Long> naturalNumbers(long n) {
        List<Long> naturalNumbers = new ArrayList<>();
        for (long i = 1; i <= n; i++) {
            naturalNumbers.add(i);
        }
        return naturalNumbers;
    }

}
