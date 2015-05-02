# Functional Reactive Programming XKE -- 7th May 2015

This is the written material that accompanies XKE.

**We will be using Java 8 as our programming language of choice in this XKE**

## You need to know

1. Basics of functional programming -- lambda expressions, higher order functions, lazy evaluation
2. Streams -- Java 8


## Topics

1. Start with Iterable -- Mother of all streams
  * How many of you have used for-each in Java?
  * If I ask you to make your own domain object work with foreach how can you do it?
  * **Demo** show how to make Xebians work with for-each.

2. Java 8 introduced another base class for all collections called Stream
    * Sequence of elements that support aggregate and transformation operations
    * Streams are immutable data structures you can't change entries in a stream, you can only apply operations on streams that gives new streams. Streams are lazy as well.
    * Streams are nothing more then combination of Iterable<T> and Iterator<T>
    * **Demo** Talk about Stream and showcase few examples

3. Explain different functions like map(), filter(), sum() using Marble diagrams

4. Streams are everywhere -- You can't do anything with past, focus on present, you are unaware of future
  * Mouse events
  * Stock prices

5. Streams are of two types
  * Streams that will give you one element at a time when you ask for it
  * Streams that will publish events/elements even if you can process it or not. -- Observable streams

6. Observable streams -- three interfaces
  * Observable
  * Observer
  * Subscription

7. The difference between Observable and Stream is that in Observable you do not have to ask for values in the stream they are delivered asynchronously.

8. Spreadhseet is mother of all reactive programming -- you change a value and all the related cells change

9. Cold vs hot observables




##Resources

1. A playful introduction to Rx by Eric Meijer https://www.youtube.com/watch?v=qIT8HLLZbtw

2.
# functional-reactive-programming-xke
