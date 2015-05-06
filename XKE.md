Lets start with a very simple program where in we have to generate a sequence of natural numbers. We can write a very simple program like the one shown below.

```java
import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that returns first n natural numbers starting from 1
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
```

There are couple of issues with the above implementation.
1. I am leaking my implementation i.e. use of List
2. The above code is not encapsulated.
3. Code is imperative


Given this program, how can you make the following program compile and run.

```java
public class Example2 {

    public static void main(String[] args) {
        NaturalNumbers naturalNumbers = naturalNumbers(100);
        for (Long naturalNumber : naturalNumbers) {
            System.out.println(naturalNumber);
        }
    }

}
```

To make the above program work you have to write your own NaturalNumbers type as shown below.

```java
import java.util.Iterator;

/**
 * Write a program that returns first n natural numbers starting from 1
 */
public class Example2 {

    public static void main(String[] args) {
        NaturalNumbers naturalNumbers = NaturalNumbers.naturalNumbers(100);
        for (Long naturalNumber : naturalNumbers) {
            System.out.println(naturalNumber);
        }
    }

    private static class NaturalNumbers implements Iterable<Long> {

        private final long n;

        private NaturalNumbers(long n) {
            this.n = n;
        }

        public static NaturalNumbers naturalNumbers(long n) {
            return new NaturalNumbers(n);
        }

        @Override
        public Iterator<Long> iterator() {
            return new NaturalNumberIterator(n);
        }

        private static class NaturalNumberIterator implements Iterator<Long> {
            private final long n;
            private long current = 0;

            public NaturalNumberIterator(long n) {
                this.n = n;
            }

            @Override
            public boolean hasNext() {
                return current < n;
            }

            @Override
            public Long next() {
                return ++current;
            }
        }
    }

}
```

Still there are issues with the above code:

1. Program is not lazy. It evaluates eagerly i.e. perform all the job when we call the `naturalNumbers()` function.
2. Code is imperative
3. We have to write lot of code for this simple program.
4. It is not possible to generate infinite natural numbers with this approach.

## How can we do better?

Java 8 to the rescue. Java 8 introduced Streams that allows us to work with collections in a functional manner. Streams provide lazy, functional, and fluent way to work with data. Streams are read-only and immutable.

```java
import java.util.stream.IntStream;

public class Example3 {

    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach(System.out::println);
    }
}
```

Although the above looks simple and cool but it still does not help us write infinite natural number sequence.

```java

import java.util.stream.LongStream;

public class Example4 {

    public static void main(String[] args) {
        LongStream.iterate(1, val -> val + 1).peek(val -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }).forEach(System.out::println);
    }

}
```

We can encapsulate the natural number stream in another static utility like the one shown below.

```java
import java.util.stream.LongStream;

public class Example4 {

    public static void main(String[] args) {
        NaturalNumbersStream.naturalNumbers().forEach(System.out::println);
    }

    private static class NaturalNumbersStream {
        public static LongStream naturalNumbers() {
            return LongStream.iterate(1, val -> val + 1);
        }
    }
}
```

## Streams are very powerful and provide rich API##

### Transformation -- map() ###

Add 10 to all the numbers in a stream
```java
IntStream.rangeClosed(1, 10).map(num -> num + 10).forEach(System.out::println);
```

### Filtering out elements -- filter()###
Print all even numbers
```java
IntStream.rangeClosed(1, 10).filter(num -> num % 2 == 0).forEach(System.out::println);
```

### Combining methods to form pipeline###
Add 10 to all numbers and then filter even numbers
```java
IntStream.rangeClosed(1, 10).map(num -> num + 10).filter(num -> num % 2 == 0). forEach(System.out::println);
```

### Other functions like sum, average, skip, limit()###
```java
IntStream.rangeClosed(1, 10).sum()
```

```java
IntStream.rangeClosed(1, 100).skip(50).limit(10).forEach(System.out::println);
```

## Stream limitations##

Streams are very powerful concept but they don't solve all the problems. Streams are synchronous by default and they are pull based.

If you think of streams as event producer then you would expect a way to subscribe to them. Streams do not support push based mechanism hence not suitable for all async event-driven applications.

## Welcome to the world of Functional Reactive Proramming##

It turns out it is a very common requirement that you want to subscribe to events emitted by a source and react on those events. Microsoft discovered this programming paradigm and created an extension to .NET framework called Rx or Reactive Extensions.

Rx is suitable for scenarios where you have to react to events i.e. your data is push based not pull based. Possible usecases:
  * UI events like mouse move, clicks etc
  * Domain events like property changed, user created, registered, etc.
  * Infrastructure events

Reactive programming is the next logical step to functional programming. Functional programming is about composition and lazy evaluation. FRP helps you focus on What then How. What style of programming is called declarative programming. How style of programming is called  imperative programming. FRP applies functional programming principles and practices to Reactive programming. The basic idea behind reactive programming is that there are certain datatypes that represent a value "over time". For more refer http://stackoverflow.com/a/1028642


## What is Functional Reactive Programming##

What is FRP? few definitions
  1. Haskell definition -> https://wiki.haskell.org/Functional_Reactive_Programming
    > Functional Reactive Programming (FRP) integrates time flow and compositional events into functional programming.

  2. Wikipedia definition -> http://en.wikipedia.org/wiki/Functional_reactive_programming
    > Functional reactive programming (FRP) is a programming paradigm for reactive programming (asynchronous dataflow programming) using the building blocks of functional programming (e.g. map, reduce, filter).

  3. Another definition
    > FRP is a different way to solve problems related to event sourcing. It helps you write event-driven logic in a composable and modular way.

  4. Another definition
  > It is replacement of Observer pattern, which is usually implemented using callbacks or listeners.

## Iterables vs Observable
Iterables allows you to **query data at rest** whereas Observable allows you to query **data in motion**.


| Event     | Iterable(Pull)     | Observable(push)|
| :------------- | :------------- ||
| retrieve data       | T next()       |onNext()|
| discover error| throw Exception | onError(Throwable)|
|complete|returns|onCompeleted|

Iterators and Observables are mathematical dual. This means you can define all the iterator operations on Observables

## Say Hello to Observable##
Print `Hello World` using Observable

```java
import rx.Observable;

public class Example5 {
    public static void main(String[] args) {
        Observable<String> observable = Observable.<String>create(subscriber -> subscriber.onNext("Hello world"));

        observable.subscribe(System.out::println);

    }
}
```

You can do transformations, filtering just like you can do on Streams.

```java
import rx.Observable;

import java.util.Arrays;

public class Example6 {

    public static void main(String[] args) {
        Observable<String> xlteam = Observable.from(Arrays.asList("shekhar", "sameer", "aditya", "ankur"));

        Observable<String> xlteamWithS = xlteam.map(String::toUpperCase).filter(name -> name.startsWith("S"));

        xlteam.subscribe(name -> System.out.println("first .. I met " + name));
        xlteam.subscribe(name -> System.out.println("second .. I met " + name));
        xlteamWithS.subscribe(name -> System.out.println("I met XL team member with name starting with S. He is " + name));

        xlteam.mergeWith(xlteamWithS).subscribe(name -> System.out.println("I met all... " + name));
    }
}
```

Generating first 10 positive natural numbers with two subscriber

```java
import rx.Observable;
import rx.schedulers.Schedulers;

public class Example7 {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(1, 10, Schedulers.newThread());
        observable.subscribe(System.out::println);
        observable.subscribe(System.out::println);

        while(true){}

    }
}
```
