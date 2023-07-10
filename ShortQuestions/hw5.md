# HW 5
2.  how to create a new thread(Please also consider Thread Pool case)?
3.  Difference between Runnable and Callable
4.  what is the diff between t.start() and t.run()?
5.  Which way of creating threads is better: Thread class or Runnable interface?
6.  what is the thread status?
7. difference between wait() and sleep() method
8.  What is deadlock?
9.  how do threads communicate with each other?
10. what is join() method?
11. what is yield() method
12. Explain thread pool
13. What is Executor Framework in Java, its different types and how to create these
    executors?
14. Difference between shutdown() and shutdownNow() methods of executor
15. What is Atomic classes? when do we use it?
16. What is the cocurrent collections?
17.  what kind of locks you know?
18. What is the difference between class lock and object lock?
19. What is future and completableFuture?
20. what is ThreadLocal?
21. Type the code by your self and try to understand it. (package
    com.chuwa.tutorial.t08_multithreading)
22. Read those interview questions and pick some important questions to this home
    work.
23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print
    2,4,6,8,10. (solution is in
    com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
    No. 1 / 3
    a. One solution use synchronized and wait notify
    b. One solution use ReentrantLock and await, signal
24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread
    output 21-22. threads run sequence is random. (solution is in
    com.chuwa.exercise.t08_multithreading.PrintNumber1)
    Thread-0: 1
    Thread-1: 2
    Thread-0: 3
    Thread-1: 4
    Thread-0: 5
    Thread-1: 6
    Thread-0: 7
    Thread-1: 8
    Thread-0: 9
    Thread-1: 10
    Process finished with exit code 0
    1
    2
    3
    4
    5
    6
    7
    8
    9
    10
    11
    12
    Thread-0: 1
    Thread-0: 2
    Thread-0: 3
    Thread-0: 4
    Thread-0: 5
    Thread-0: 6
    Thread-0: 7
    Thread-0: 8
    Thread-0: 9
    Thread-0: 10
    Thread-2: 11
    Thread-2: 12
    Thread-2: 13
    Thread-2: 14
    Thread-2: 15
    Thread-2: 16
    1
    2
    3
    4
    5
    6
    7
    8
    9
    10
    11
    12
    13
    14
    15
    16
    No. 2 / 3
25. completable future:
    a. Homework 1: Write a simple program that uses CompletableFuture to
    asynchronously get the sum and product of two integers, and print the
    results.
    b. Homework 2: Assume there is an online store that needs to fetch data
    from three APIs: products, reviews, and inventory. Use
    CompletableFuture to implement this scenario and merge the fetched
    data for further processing. (需要找public api去模拟，)
    i.  Sign In to Developer.BestBuy.com
    ii. Best Buy Developer API Documentation
    (bestbuyapis.github.io)
    iii.  可以用fake api https://jsonplaceholder.typicode.com/
    c.  Homework 3: For Homework 2, implement exception handling. If an
    exception occurs during any API call, return a default value and log the
    exception information.

## Q1.  Explain volatile variables in java? (we also use it in Singleton)
```

```

## Q2.  how to create a new thread(Please also consider Thread Pool case)?
```
```

## Q3.  Difference between Runnable and Callable
```
```

## Q4.  what is the diff between t.start() and t.run()?
```
```

## Q5.  Which way of creating threads is better: Thread class or Runnable interface?
```
```

## Q6.  what is the thread status?
```

```

## Q7. difference between wait() and sleep() method
```
```

## Q8.  What is deadlock?
```

```

## Q9.  how do threads communicate with each other?
```
```

## Q10. what is join() method?
```
```

## Q11. what is yield() method
```
```

## Q12. Explain thread pool
```
```

## Q13. What is Executor Framework in Java, its different types and how to create these executors?
```

```

## Q14. Difference between shutdown() and shutdownNow() methods of executor
```
```

## Q15. What is Atomic classes? when do we use it?
```

```

## Q16. What is the cocurrent collections?
```
```

## Q17.  what kind of locks you know?
```
```

## Q18. What is the difference between class lock and object lock?
```

```

## Q19. What is future and completableFuture?
```
```

## Q20. what is ThreadLocal?
```
```

## Q21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
```

```

## Q22. Read those interview questions and pick some important questions to this homework.
```
```

## Q23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)No. 1 / 3
a. One solution use synchronized and wait notify
b. One solution use ReentrantLock and await, signal
```
coding is in the coding folder
```

## Q24: completable future:
a. Homework 1: Write a simple program that uses CompletableFuture to
asynchronously get the sum and product of two integers, and print the
results.
b. Homework 2: Assume there is an online store that needs to fetch data
from three APIs: products, reviews, and inventory. Use
CompletableFuture to implement this scenario and merge the fetched
data for further processing. (需要找public api去模拟，)
i.  Sign In to Developer.BestBuy.com
ii. Best Buy Developer API Documentation
(bestbuyapis.github.io)
iii.  可以用fake api https://jsonplaceholder.typicode.com/
c.  Homework 3: For Homework 2, implement exception handling. If an
exception occurs during any API call, return a default value and log the
exception information
```
coding is in the coding folder
```