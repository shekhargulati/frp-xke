package org.shekhar.xke.frp.introtorx.creational;

import rx.Observable;
import rx.util.async.Async;

import java.math.BigInteger;
import java.util.Objects;

public class StartExample {
    public static void main(String[] args) {
        Observable<BigInteger> factorialObservable = Async.start(() -> factorial(BigInteger.valueOf(100)));
        factorialObservable.subscribe(val -> System.out.println(val));

        while(true){}


    }

    private static BigInteger factorial(BigInteger n) {
        if (Objects.equals(n, BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }
}
