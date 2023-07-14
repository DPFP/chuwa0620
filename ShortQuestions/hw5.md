# HW 5
## Q1.  Explain volatile variables in java? (we also use it in Singleton)
```
A volatile keyword is used to modify the value of a variable by different threads
```

## Q2.  how to create a new thread(Please also consider Thread Pool case)?
```
Example 1:
Thread thread = Thread.currentThread();
Example 2: 
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.execute(new Runnable() {
    public void run() {
        // Code to be executed in a new thread
    }
});
executor.shutdown();
```

## Q3.  Difference between Runnable and Callable
```
Callable returns something
```

## Q4.  what is the diff between t.start() and t.run()?
```
When a program calls the start() method, a new thread is created and then the run() method is execute.
No new thread is created and the run() method is executed on the calling thread itself.
```

## Q5.  Which way of creating threads is better: Thread class or Runnable interface?
```
Runnable, this method is more flexible. It allows your class to extend from any other class.
```

## Q6.  what is the thread status?
```
 New, Runnable, Waiting, Timed Waiting, Terminated
```

## Q7. difference between wait() and sleep() method
```
The major difference is that wait() releases the lock or monitor while sleep() doesn’t releases the lock or monitor
 while waiting. wait() is used for inter-thread communication while sleep() is used to introduce pause on execution
```

## Q8.  What is deadlock?
```
A deadlock is a situation where a set of processes are blocked because each process is holding a resource and waiting 
for another resource acquired by some other process
```

## Q9.  how do threads communicate with each other?
```
synchronization primitives like locks and semaphores, events like wait and notify, or through shared memory
```

## Q10. what is join() method?
```
It allows one thread to wait for the completion of another thread before proceeding.
```

## Q11. what is yield() method
```
 It is used to suggest to the scheduler that the current thread is willing to yield its current time slice to other
  threads of the same priority
```

## Q12. Explain thread pool
```
A Thread Pool is a collection of worker threads that efficiently execute asynchronous callbacks on behalf of the application.
```

## Q13. What is Executor Framework in Java, its different types and how to create these executors?
```
The Executor Framework contains a bunch of components that are used to efficiently manage multiple threads
ThreadPoolExecutor
ScheduledThreadPoolExecutor
ForkJoinPool
SingleThreadExecutor
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.execute(() -> {
// Task
});
executor.execute(() -> {
// Task 2
});
executor.shutdown();
```

## Q14. Difference between shutdown() and shutdownNow() methods of executor
```
The shutdown() method will allow previously submitted tasks to execute before terminating,
 while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks
```

## Q15. What is Atomic classes? when do we use it?
```
The atomic classes provide a lock-free and thread-safe environment or programming on a single variable.
```

## Q16. What is the cocurrent collections?
```
Thread safe version of collections
```

## Q17.  what kind of locks you know?
```
- ReentrantLock
- synchronized
- ReadWriteLock
- StampedLock
```

## Q18. What is the difference between class lock and object lock?
```
Object Level Locks − It can be used when you want non-static method or non-static block of the code should be accessed 
by only one thread. 
Class Level locks − It can be used when we want to prevent multiple threads to enter the 
synchronized block in any of all available instances on runtime
```

## Q19. What is future and completableFuture?
```
A Future is used as a reference to the result of an asynchronous computation.
CompletableFuture implements Future and CompletionStage interfaces and provides a huge set of convenience methods for
 creating, chaining and combining multiple Futures. It also has a very comprehensive exception handling support.
```

## Q20. what is ThreadLocal?
```
A thread-local variable is a variable that is local to each thread and is not shared among multiple threads.
```

## Q21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
```
Code is in coding folder.
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
Homework1
public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> num1 + num2);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> num1 * num2);

        CompletableFuture<Void> resultFuture = CompletableFuture.allOf(sumFuture, productFuture);

        resultFuture.thenRun(() -> {
            int sum = sumFuture.join();
            int product = productFuture.join();

            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
        });

        // Ensure the main thread waits for the results to be printed
        resultFuture.join();
    }
```
Homework2
```
public class Solution {
    public static void main(String[] args) {
        // Fetch data from three APIs concurrently
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchProducts());
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchReviews());
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchInventory());

        // Combine the results using 'thenCombine'
        CompletableFuture<String> combinedFuture = productsFuture.thenCombine(reviewsFuture, (products, reviews) ->
                        "Products: " + products + "\nReviews: " + reviews)
                .thenCombine(inventoryFuture, (result, inventory) ->
                        result + "\nInventory: " + inventory);

        // Perform further processing when all data is available
        combinedFuture.thenAccept(result -> {
            System.out.println("Data Fetched:\n" + result);
            // Perform further processing with the merged data
        });

        // Ensure the main thread waits for the results to be processed
        combinedFuture.join();
    }

    // Fake methods simulating API calls
    private static String fetchProducts() {
        // Simulate API call delay
        sleep(2000);
        return "Product Data";
    }

    private static String fetchReviews() {
        // Simulate API call delay
        sleep(1500);
        return "Review Data";
    }

    private static String fetchInventory() {
        // Simulate API call delay
        sleep(1000);
        return "Inventory Data";
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
Homework3
```
public class Solution {
    private static final Logger logger = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchProducts();
            } catch (Exception e) {
                handleException("Error fetching products", e);
                return "Default Product Data";
            }
        });

        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchReviews();
            } catch (Exception e) {
                handleException("Error fetching reviews", e);
                return "Default Review Data";
            }
        });

        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchInventory();
            } catch (Exception e) {
                handleException("Error fetching inventory", e);
                return "Default Inventory Data";
            }
        });

        CompletableFuture<String> combinedFuture = productsFuture.thenCombine(reviewsFuture, (products, reviews) ->
                        "Products: " + products + "\nReviews: " + reviews)
                .thenCombine(inventoryFuture, (result, inventory) ->
                        result + "\nInventory: " + inventory);

        combinedFuture.thenAccept(result -> {
            System.out.println("Data Fetched:\n" + result);
            // Perform further processing with the merged data
        });

        combinedFuture.join();
    }

    private static String fetchProducts() throws Exception {
        // Simulate API call delay
        sleep(2000);
        // Simulate exception
        throw new RuntimeException("Exception occurred while fetching products");
    }

    private static String fetchReviews() throws Exception {
        // Simulate API call delay
        sleep(1500);
        return "Review Data";
    }

    private static String fetchInventory() throws Exception {
        // Simulate API call delay
        sleep(1000);
        return "Inventory Data";
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void handleException(String message, Throwable exception) {
        logger.log(Level.SEVERE, message, exception);
    }

}
```