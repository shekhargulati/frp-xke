# Functional Reactive Programming XKE -- 7th May 2015

This is the written material that accompanies XKE.

**We will be using Java 8 as our programming language of choice in this XKE**

## You need to know

1. Basics of functional programming -- lambda expressions, higher order functions, lazy evaluation
2. Streams -- Java 8


## Basics of Functional programming

1. **Higher order functions:**

2. **Lambda expressions:**

3. **Referential transparency or purity:** A function should not have any side effects and it should return the same value each time you call it with same arguments.

4. **Immutability:**

5. **Recursion:**

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

8. Spreadsheet is mother of all reactive programming -- you change a value and all the related cells change

9. Cold vs hot observables

10. What FRP is not
  * A solution for problems you can't already solve
  * Well-support by most languages mainly due to constructs and features they support
  * IT IS NOT REACT.JS

11. What is FRP? few definitions
  1. Haskell definition -> https://wiki.haskell.org/Functional_Reactive_Programming
    > Functional Reactive Programming (FRP) integrates time flow and compositional events into functional programming.

  2. Wikipedia definition -> http://en.wikipedia.org/wiki/Functional_reactive_programming
    > Functional reactive programming (FRP) is a programming paradigm for reactive programming (asynchronous dataflow programming) using the building blocks of functional programming (e.g. map, reduce, filter).

  3. Another definition
    > FRP is a different way to solve problems related to event sourcing. It helps you write event-driven logic in a composable and modular way.

  4. It is replacement of Observer pattern, which is usually implemented using callbacks or listeners.


12. Common domains where FRP is useful -- GUI, robotics, music industry,

13. FRP makes it easy to combine time stream with value stream to form a thing stream.

14. Compare approaches

| OLD     | FRP |
| :------------- | :------------- |
| ``` on_click(function(e){ log(e.position)  })``` |``` clicks.map(e -> log(e.position))``` |

15. Composition allows you to compose streams using other streams

16. Everything is a stream

17. Interactive is opposite of reactive programming. This is what we are used to.

18. Interacting == pulling whereas reactive == pushing

19. Iterators and Observables are mathematical dual. This means you can define all the iterator operations on Observables

20. Rx is reactive extensions -- created by Eric Meijer

21. Reactive manifesto -- take reactive programming principles to build reactive applications

22. Functional Reactive programming is an intersection of functional programming and reactive programming. Reactive programming is not same as functional reactive programming.

23. FRP applies functional programming principles and practices to Reactive programming. The basic idea behind reactive programming is that there are certain datatypes that represent a value "over time". For more refer http://stackoverflow.com/a/1028642

24. Explain Observer pattern -- Ancient way to write reactive applications where consumers register themselves with the producer.For more http://en.wikipedia.org/wiki/Observer_pattern

25. Why observer pattern should be depricated?
  * http://stackoverflow.com/questions/11619680/why-should-the-observer-pattern-be-deprecated
  * Depreciating the Observer Pattern paper http://infoscience.epfl.ch/record/176887/files/DeprecatingObservers2012.pdf

26. FRP is a form of dataflow programming. Dataflow programming is defined in terms of directed graph as opposed to linear Von Neumann model. To learn more about Dataflow programming refer to this paper http://paginas.fe.up.pt/~prodei/dsie12/papers/paper_17.pdf

27. FRP helps you focus on What then How. What style of programming is called declarative programming. How style of programming is called  imperative programming.

28. FRP is based on event streams, a stream that produces events along a timeline.

29. Observables allows you to work with collections asynchronously where as future allows you to work with one value asynchronously.

|| One | Many     |
| :------------- | :------------- |
| Sync| T       | Iterable<T>     |
|Async| Future<T> | Observable<T>    |

30. Reactive programming is the next logical step to functional programming. Functional programming is about composition and lazy evaluation.

31. Rx is suitable for scenarios where you have to react to events i.e. your data is push based not pull based. Possible usecases:
  * UI events like mouse move, clicks etc
  * Domain events like property changed, user created, registered, etc.
  * Infrastructure events

32. There are two key types in Rx -- Observable and Observer

33. Rx allows you to query data in motion

34. Think of anything that implements Observable as stream of events. In RxJava Observable is a class.

35. Observable API methods can be grouped in four categories:
  * Creational -- create, timer, interval, from
  * Filtering
  * Aggregation
  * Transformation

36. 


##Resources

1. A playful introduction to Rx by Eric Meijer https://www.youtube.com/watch?v=qIT8HLLZbtw


## Demo applications

1. Sentiment analysis of twitter stream

2. Website that monitors uptime of web applications

3.  
