## Q1 Explain volatile variables in java? (we also use it in Singleton)
volatile variables in Java ensure that the value of the variable is always read from and written to the main memory, rather than from a thread's local cache, making it visible to all threads and ensuring consistent visibility. It is commonly used in Singleton design pattern to provide a synchronized and thread-safe instance creation.

## Q2 how to create a new thread(Please also consider Thread Pool case)?

Extends from Thread class
```Java
class MyThread extends Thread {
    @Override
    public void run() {

    }
};

MyThread thread = new MyThread();
thread.start();
```

Implements the Runnable interface
```Java
Runnable myRunnable = new Runnable() {
    @Override
    public void run() {

    }
};
Thread thread = new Thread(myRunnable);
thread.start();
```
Executor to create threadpool
```Java
ExecutorService executor = Executors.newFixedThreadPool(poolSize);
executor.execute(()-> {

});
executor.shutdown;
```
Callable and Future
```Java
Callable<Integer> myCallable = () -> {
    return 42;
};

ExecutorService executor = Executors.newFixedThreadPool(poolSize);
Future<Integer> future = executor.submit(myCallable);

try {
    Integer res = future.get();
    System.out.println("result is :" + result);
} catch (InterruptedException | ExecutionException e) {

} finally {
    executor.shutdown();
}
```

## Q3 Difference between Runnable and Callable?
The Runnable cannot have return value, but the Callable can have return value.
The Runnable cannot throw the exception, but the Callable can throw the exception.

## Q4 what is the diff between t.start() and t.run()?
The start() is used to start a new thread and execute the code in run() concurrently. The run() executes the code in run() sequentially on the same calling thread without starting a new thread. It is essential to use t.start() to achieve the desired concurrent behavior when working with multithreading.

## Q5 Which way of creating threads is better: Thread class or Runnable interface?
Because Java only have single inheritance, so Thread class is less flexible than Runnable interface.

## Q6 What is the thread status?
New, Runnable, Blocked, Waiting, Timed Waiting, Terminated.

## Q7 difference between wait() and sleep() method?
wait() will release the lock, but the sleep won't release the lock.

## Q8 What is deadlock?
Deadlock refers to a situation in concurrent programming where two or more threads are blocked indefinitely, waiting for each other to release resources or complete certain actions.

## Q9 how do threads communicate with each other?
1. Shared Variables
2. Thread Synchronization
3. Thread Signaling
4. Message Passing
5. Thread Join
6. Thread Pooling

## Q10 what is join() method?
the join() method is a synchronization mechanism provided by the Thread class that allows one thread to wait for the completion of another thread.

## Q11 what is yield() method?
It is used to suggest to the thread scheduler that the current thread is willing to yield its current execution and allow other threads of the same priority to run.

## Q12 Explain thread pool
A thread pool is a managed collection of pre-initialized threads that can be used to execute tasks concurrently. Instead of creating a new thread for each task, a thread pool reuses a set of worker threads, which can significantly improve performance and resource management in multi-threaded applications.

## Q13 What is Executor Framework in Java, its different types and how to create these  executors?
The Executor framework in Java provides a higher-level abstraction for managing and executing tasks asynchronously in a controlled manner. It abstracts away the complexity of managing threads manually and offers a way to decouple task submission from execution, making it easier to handle concurrency and thread management.

```Java
ExecutorService fixedThreadPool = Executors.newFixedThreadPool(poolSize);
ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(poolSize);
ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
```

## Q14. Difference between shutdown() and shutdownNow() methods of executor
shutdown() initiates an orderly shutdown, allowing the execution of submitted tasks to complete, while shutdownNow() forcefully terminates the ExecutorService, interrupting the running tasks. It's important to note that even after calling shutdownNow(), there is no guarantee that all tasks will be stopped immediately, as it depends on how the tasks themselves respond to interruption.

## Q15. What is Atomic classes? when do we use it?
java.util.concurrent.atomic package, provide a way to perform atomic operations on shared variables without the need for explicit synchronization.And they will ensure that operations on the variables are performed atomically and avoid potential data races in concurrent programming scenarios.

## Q16. What is the cocurrent collections?
They are collections ensured thread safety and achieve better performance in multi-threaded environments.

## Q17.  what kind of locks you know? 
ReentrantLock, ReadWriteLock, StampedLock, ReentrantReadWriteLock, Condition.

## Q18. What is the difference between class lock and object lock?
The class lock is associated with the class itself and provides class-level synchronization, while the object lock is associated with individual instances of a class and provides instance-level synchronization. They serve different purposes and control different levels of concurrent access to resources.

## Q19. What is future and completableFuture?
Future provides basic support for obtaining the result of an asynchronous computation, CompletableFuture extends Future and adds powerful capabilities for composing, chaining, and handling asynchronous tasks. CompletableFuture is preferred in modern Java applications for advanced asynchronous programming needs, offering greater flexibility and expressiveness.

## Q20. What is ThreadLocal?
ThreadLocal is a class in Java that provides thread-local variables. A thread-local variable is a variable that is stored and accessed separately for each thread. Each thread that accesses a ThreadLocal variable has its own, independently initialized copy of the variable.


## Q23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
```Java
public class Solution {
    private static final Object lock = new Object();
    private static volatile int currentNumber = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (currentNumber <= 10) {
                synchronized (lock) {
                    if (currentNumber % 2 != 0) {
                        System.out.println(currentNumber);
                        currentNumber++;
                        lock.notify(); // Notify evenThread to continue
                    } else {
                        try {
                            lock.wait(); // Wait for evenThread to print
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (currentNumber <= 10) {
                synchronized (lock) {
                    if (currentNumber % 2 == 0) {
                        System.out.println(currentNumber);
                        currentNumber++;
                        lock.notify(); // Notify oddThread to continue
                    } else {
                        try {
                            lock.wait(); // Wait for oddThread to print
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
```

## Q24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. 
```Java
public class Solution {
    private static int n = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumber());
        Thread t2 = new Thread(() -> printNumber());
        Thread t3 = new Thread(() -> printNumber());

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber() {
        int count = 10;
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + n++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Solution.class.notifyAll();
    }
}
```
## Q25 completable future: a. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results. b. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找public api去模拟，)i.  Sign In to Developer.BestBuy.com ii. Best Buy Developer API Documentation (bestbuyapis.github.io) iii.  可以用fake api https://jsonplaceholder.typicode.com/ c.  Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the  exception information

Homework1
```Java
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
```Java
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
```Java
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