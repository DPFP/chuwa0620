## HW4
### Name: Yuanzhen Lin

### 1. Explain volatile variables in java? (we also use it in Singleton)
In Java, the volatile keyword is used to indicate that a variable's value can be modified by different threads. It is used to make classes thread-safe, meaning that multiple threads can use a method or class without causing problems.

- Visibility: \
When a variable is declared as volatile, it ensures that any thread that reads the field will see the most recently written value. In the absence of volatile, there's no such guarantee (due to things like thread caching). It's important when the value of a variable can be changed by multiple threads, and these changes need to be immediately visible to other threads.

- Ordering: \
The volatile keyword also provides a "happens-before" guarantee. This means that changes to a volatile variable are always visible to other threads. What's more, it means that when a thread reads a volatile variable, it sees not just the latest change to the volatile, but also the side effects of the code that led up the change.

- Atomicity: \
It's important to note that the volatile keyword guarantees atomic reads and writes for all variables (except long and double). This means that when a value is written to a volatile variable, the write operation is done atomically, so other threads will either see the old or the new value, but nothing in-between. However, volatile cannot provide atomicity for compound operations like volatileVar++, which are read-modify-write operations.

The volatile keyword is used less frequently than other modifiers in Java because it's used only under specific conditions when you're dealing with multithreading and you need to ensure changes to a variable are immediately read by other threads. When not used carefully, it can lead to inefficient code due to the fact that it prevents certain compiler optimizations that assume access by a single thread.

### 2. how to create a new thread(Please also consider Thread Pool case)?
- Extends Thread Class
```aidl
public class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("starting new thread using extends thread);
    }
}
Thread t = new MyThread();
t.start();
```
- Implements Runnable
```aidl
public class MyRunnable implements Runnable {
    @Override 
    public void run(){
        System.out.println("Start new thread using Runnable);
    }
}
Thread t2 = new Thread(new MyRunnable());
```
- Implements Callable
```aidl
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        return "Start new thread using callable";
    }
}
```
- Thread Pool
```aidl
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.submt(task1);
```

### 3. Difference between Runnable and Callable
- Return Value: \
Callable tasks return a value. The Callable interface is a parameterized interface, meaning you can specify what type the return value will be. On the other hand, Runnable tasks do not return a value. The run() method in Runnable returns void.
- Exception Handling: \
The Callable.call() method can throw checked exceptions, whereas Runnable.run() cannot. If your task logic needs to handle or throw some checked exceptions, then you should use a Callable.
- Usage with ExecutorService: \
When you submit a Runnable to an ExecutorService, you get a Future<?> as a return, but you can only use it to check if the computation is done, or to forcibly cancel it. You can't use it to retrieve a computation result. If you submit a Callable to an ExecutorService, you get a Future<V> (where V is the type parameter of your Callable), and you can use it to retrieve a value computed by the task (using Future.get()), in addition to other Future operations.

### 4. what is the diff between t.start() and t.run()?
t.start(): This method is used to initiate a thread. It creates a new thread that will execute the code in the run() method concurrently with the rest of the program. When you call t.start(), the Java Virtual Machine calls the run() method on the new thread, not on the current thread. It's important to note that you can't directly call start() again on a thread that has completed its execution or already started - doing so will lead to an IllegalThreadStateException.

### 5. Which way of creating threads is better: Thread class or Runnable interface?
The preferred way is generally to implement the Runnable interface, and there are several reasons for this:
- Java does not support multiple inheritance: \
If you extend the Thread class, your class cannot extend any other class because Java doesn't allow multiple inheritance. However, your class can implement multiple interfaces. So if you implement Runnable, your class can still extend some other class.
- Runnable represents a task: \
The Runnable interface represents a task which can be executed by any thread, not just a specific instance of a thread. This makes your code more flexible. For example, you can reuse the same Runnable implementation with multiple threads, you can use it with different ExecutorService implementations, or you can call the run() method directly in some thread if you want. The Runnable objects can also be used with a lot of the concurrency API, like ThreadPoolExecutor or ScheduledExecutorService, which accept Runnable tasks.
- Loose coupling: \
Using Runnable creates a looser coupling between your task (the Runnable's run method) and the code that executes it (the Thread or executor that calls Runnable.run), which makes your code more flexible and modular.
- Favors composition over inheritance: \
In general, Java best practices and object-oriented design principles favor composition over inheritance. When you implement Runnable, you're basically following the strategy pattern, encapsulating a "family of algorithms" (i.e., things that you can run()) into an object.

### 6. what is the thread status?
A thread in Java can be in one of several states, also referred to as thread states or thread status. Below are the possible states:

- NEW: \
The thread has been declared but its start() method has not yet been called. The thread is not considered to be executing any code and will not be scheduled by the system.

- RUNNABLE (or RUNNING): \
The thread's start() method has been called and the thread is eligible to be run by the scheduler. The thread may or may not be currently running (executing code) depending on the scheduler's decision.

- BLOCKED: \
The thread is currently blocked waiting for a monitor lock to enter a synchronized block/method. This happens when a thread attempts to enter a synchronized block of code that is currently locked by another thread. The thread will remain blocked until it can acquire the lock.

- WAITING: \
The thread is waiting indefinitely for another thread to perform a particular action. For example, a thread that has called Object.wait() on an object is waiting for another thread to call Object.notify() or Object.notifyAll() on that object.

- TIMED_WAITING: \
The thread is waiting for another thread to perform a specific action, but it's waiting for a specific amount of time. For example, a thread that has called Thread.sleep(1000) is in a timed waiting state.

- TERMINATED (or DEAD): \
The thread has completed execution or has been forcibly stopped with stop() method (which is not recommended because of thread safety issues).

### 7. difference between wait() and sleep() method
wait() and sleep() are two methods in Java that are used to pause the execution of a thread, but they are used for different purposes and have significant differences:
- Synchronization Context: \
The wait() method is defined in the Object class, and it's used for inter-thread communication. It must be called from a synchronized context (a synchronized method or block), otherwise it will throw an IllegalMonitorStateException. When a thread calls wait() on an object, it releases the monitor (lock) on the object, allowing other threads to synchronize on it.\
On the other hand, sleep() is a static method in the Thread class, and it doesn't interact with the object monitor or the synchronization mechanism. It simply causes the currently executing thread to pause for a specified period of time, without releasing any locks that the thread might hold.

- Wake-up Mechanism: \
After a thread calls wait(), it enters the WAITING state and it remains there until some other thread calls notify() or notifyAll() on the same object.\
When a thread calls sleep(), it enters the TIMED_WAITING state and it wakes up and becomes RUNNABLE again after the specified sleep time has elapsed, or if the thread was interrupted.

- Usage Purpose: \
wait(), notify(), and notifyAll() are used for inter-thread communication. They are typically used in scenarios where one thread needs to wait for one or more other threads to complete some operation before it can continue.\
sleep(), however, is usually used to introduce a delay/pause in the execution, for example, to simulate time-consuming operations, or to introduce a delay for retry logic in case of failures.

### 8. What is deadlock?
A deadlock in multi-threading is a situation where two or more threads are blocked forever, waiting for each other to release resources. Essentially, a deadlock occurs when multiple threads need the same locks but obtain them in different order. Each thread is waiting for a lock that another thread holds, so they end up waiting indefinitely, as none of them can proceed.

### 9. how do threads communicate with each other?
- Shared Variables: \
This is the most direct method of communication. Threads can read from and write to shared variables. However, this can lead to race conditions if not properly synchronized, which means some form of mutual exclusion (like synchronized blocks or methods) is often required. Additionally, the volatile keyword can be used to ensure that changes to a variable by one thread are immediately visible to other threads.
- Wait/Notify Mechanism: \
The Object class in Java provides wait(), notify(), and notifyAll() methods that threads can use to communicate. A thread can call wait() to wait until another thread calls notify() or notifyAll(). This is often used for scenarios where a thread needs to wait for some condition to be met by another thread.
- Blocking Queues: \
Java's java.util.concurrent package provides several classes that can be used for inter-thread communication, including various types of BlockingQueues. These queues can be used to safely pass data from one thread to another.
- CountDownLatch, CyclicBarrier, and Semaphore:\
These are high-level concurrency utilities provided by the java.util.concurrent package, which can help coordinate and communicate among multiple threads. For example, CountDownLatch can help one thread to wait until one or more other threads have completed certain tasks. Semaphore can control the number of threads accessing a certain resource, and CyclicBarrier can make multiple threads wait until they reach a common barrier point.
- Atomic Variables: \
The java.util.concurrent.atomic package provides a set of atomic variables, such as AtomicInteger, AtomicLong, etc. These classes provide methods for atomic operations and can be used to communicate state between threads in a thread-safe manner without using synchronized blocks.
- The Condition interface is associated with a Lock and it provides await(), signal(), and signalAll() methods which are similar to Object's wait(), notify(), and notifyAll() methods, respectively.

### 10. what is join() method?
The join() method in Java is a method of the Thread class which is used to pause the current thread until the specified thread (the thread on which the join() method is invoked) dies.

Consider a situation where there's a main thread that starts a new child thread. If the main thread needs to wait until the child thread finishes its execution, then the join() method comes into play.
```aidl
// Start a new thread
Thread t = new Thread(() -> {
    for(int i = 0; i < 5; i++) {
        System.out.println("Child thread: " + i);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});

t.start();

// Now, join it from the main thread
try {
    t.join();
} catch (InterruptedException e) {
    e.printStackTrace();
}

System.out.println("Main thread finished");
```

### 11. what is yield() method?
The yield() method is a static method in the Thread class in Java. When called, it "suggests" to the thread scheduler that the current thread is willing to yield its current use of a processor. The thread scheduler is free to ignore this hint.

If the thread scheduler accepts this hint, the thread that called yield() transitions from running state to runnable state. This allows other threads a chance to execute. However, there are no guarantees which thread will be scheduled next, including the possibility of the same thread that called yield() being scheduled again.

### 12. Explain thread pool
A thread pool is a group of pre-instantiated, idle threads which stand ready to be given work. These are preferred over instantiating new threads for each task when there is a large number of short tasks to be done rather than a small number of long ones. This prevents having to incur the overhead of frequently creating, starting, and destroying threads.

The java.util.concurrent.ExecutorService interface is a higher-level replacement for working with threads directly. Executors are capable of managing a pool of threads, so we do not have to manually create new threads and run tasks in an asynchronous fashion.

You can create a thread pool in Java using the Executors utility class, which provides several methods for creating different types of thread pools, including:

- Executors.newFixedThreadPool(int nThreads): \
This creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue. At any point, at most nThreads will be active processing tasks. If additional tasks are submitted when all threads are active, they will wait in the queue until a thread is available.

- Executors.newSingleThreadExecutor(): \
This creates a single-threaded executor that uses a single worker thread operating off an unbounded queue. Unlike the other methods of the Executors class, a single-threaded executor creates a single worker thread to process tasks, and will replace it if it gets killed due to an exception.

- Executors.newCachedThreadPool(): \
This creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available. The cached thread pool has the characteristic of automatically managing the pool size: when a new task is submitted and no idle threads are available, a new thread gets created.

### 13. What is Executor Framework in Java, its different types and how to create these executors?
The Executor Framework in Java is a high-level replacement for working with threads directly. It provides a layer of abstraction over the raw thread handling tasks like creating, starting, and managing the life-cycle of threads.

The Executor framework is part of java.util.concurrent package and consists of the Executor interface, Executors utility class, ExecutorService interface, ScheduledExecutorService interface and several classes implementing these interfaces.

Here are the core interfaces and classes of the Executor framework:

- Executor Interface: \
This is a simple interface that supports launching new tasks. It provides a way of decoupling task submission from the mechanics of how each task will be run, including details of thread use, scheduling, etc.

- ExecutorService Interface: \
It is a subinterface of Executor, which adds features that help manage the lifecycle of tasks and executor itself.

- ScheduledExecutorService Interface: \
It is a subinterface of ExecutorService, used to schedule commands to run after a given delay, or to execute periodically.

- Executors Class: \
It is a utility class that provides factory methods for various types of executor services.

### 14. Difference between shutdown() and shutdownNow() methods of executor
The shutdown() and shutdownNow() methods are used to terminate the executor service in Java's concurrent API, but they behave in different ways.

1. shutdown():

The shutdown() method initiates a graceful shutdown where the executor service stops accepting new tasks, but continues to process the already submitted tasks including those that are queued. The tasks that are in progress are allowed to finish, but no new tasks will be accepted.

This method does not wait for actively executing tasks to terminate. It returns after requesting shutdown. You can determine whether all tasks have completed using awaitTermination(long timeout, TimeUnit unit) method.

2. shutdownNow():

The shutdownNow() method attempts to stop all executing tasks right away, and returns a list of tasks that were waiting to be processed. It tries to halt the processing of all working threads and returns a list of tasks that were in the queue but were not processed.

However, it doesn't guarantee that the actively executing tasks will stop immediately. These tasks should handle InterruptedException properly to be able to exit before completion.

For most situations, you would want to use shutdown() as it allows the executor service to clean up its tasks before closing. However, there may be situations where you want to immediately stop all tasks, in which case shutdownNow() would be more appropriate.

### 15. What is Atomic classes? when do we use it?
Atomic classes in Java are part of the java.util.concurrent.atomic package and are used for performing atomic operations, which are thread-safe operations that are done without the use of synchronization.

An operation is atomic when you can safely perform the operation in parallel on multiple threads without using the synchronized keyword or locks. This can be particularly useful in high-concurrency applications as it leads to less blocking and therefore higher performance.

Java provides several atomic classes like AtomicInteger, AtomicLong, AtomicBoolean, AtomicReference, etc. Each of these classes provides methods to perform atomic operations for their respective types.

You use atomic classes in situations where you want to:

- Avoid synchronization: Atomic classes provide a high-performance alternative to synchronized blocks for certain types of operations.

- Avoid race conditions: If you have multiple threads reading and writing a variable simultaneously, atomic classes provide a convenient way to avoid race conditions without explicit synchronization.

- Implement lock-free data structures or algorithms: Atomic classes can be used to implement high-performance, concurrent data structures or algorithms that are free from locks.

- Ensure visibility of shared mutable variables: Atomic variables have a similar memory semantics as volatile variables, which means updates to an atomic variable are always visible to other threads.

### 16. What is the cocurrent collections?
Concurrent collections in Java are thread-safe collections provided by the java.util.concurrent package. These collections help to achieve high throughput and concurrency in multithreaded programs.

Traditionally, Java collections (like ArrayList, HashMap, HashSet, etc.) are not thread-safe, meaning they don't perform well in a multithreaded environment where multiple threads might try to modify the collection at the same time.

Here are some important concurrent collections:

- ConcurrentHashMap: \
It's a thread-safe version of HashMap. It does not lock the entire collection while adding or updating the map. Instead, it divides the map into segments and locking is done on those segments.

- CopyOnWriteArrayList & CopyOnWriteArraySet: \
These are thread-safe versions of ArrayList and HashSet. They achieve thread-safety by creating a cloned copy of the collection for every update operation at the cost of using more memory. They provide better performance when iteration is more frequent than modification.

- BlockingQueue: \
It's an interface that represents a queue which is thread-safe to put into and take instances from. Several implementations like ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue etc are provided.

- ConcurrentLinkedQueue & ConcurrentLinkedDeque: \
These are thread-safe versions of Queue and Deque.

- ConcurrentSkipListSet & ConcurrentSkipListMap: \
These are scalable concurrent ConcurrentNavigableSet and ConcurrentNavigableMap implementations.

These collections should be used in applications where high concurrency is needed and there is a potential for thread contention when using regular or synchronized collections.

### 17. what kind of locks you know?
- Intrinsic Locks (or Monitor Locks): \
These are the basic form of locks provided by the Java language as a part of every object. They are used to implement synchronized blocks or methods. Only one thread can hold the intrinsic lock at a time - if a thread t1 is inside a synchronized block and another thread t2 tries to enter a synchronized block on the same object, t2 will block until t1 exits the block.
- Reentrant Locks: \
The java.util.concurrent.locks.ReentrantLock class implements a reentrant mutual exclusion Lock with the same basic behavior and semantics as the implicit monitor lock, but with extended capabilities. It allows more flexibility in usage than intrinsic locks, for instance, it has methods to check if the lock is held, to get the list of waiting threads, to try to acquire the lock without blocking, etc. As the name suggests, a thread can acquire a reentrant lock multiple times.
- Read/Write Locks: \
The java.util.concurrent.locks.ReadWriteLock interface maintains a pair of associated locks, one for read-only operations and one for writing. The read lock may be held simultaneously by multiple reader threads, so long as there are no writers. The write lock is exclusive.
- Stamped Locks: \
Introduced in Java 8, the java.util.concurrent.locks.StampedLock class is another form of lock that also supports read and write locks like ReadWriteLock. It's an improvement over ReadWriteLock in terms of performance and capabilities. One of its unique features is the support for "optimistic reads" that can improve performance in some scenarios.
- Fairness in Locks: \
Both ReentrantLock and ReentrantReadWriteLock support "fair" and "unfair" modes. In fair mode, the locks favor granting access to the longest-waiting thread. Otherwise, this ordering is not guaranteed (unfair mode), and programs using fair locks accessed by many threads may display lower overall throughput (i.e., are slower overall) than those using unfair locks.

### 18. What is the difference between class lock and object lock?
1. Object Lock:\
Object level lock or instance lock is used when you want to synchronize non-static methods or non-static block of code. Each instance of the class has its own object level lock which is not shared with other instances. When a thread acquires an object level lock, it prevents any other thread from accessing synchronized non-static methods or blocks of that object. However, other threads can still access non-synchronized methods of that object or synchronized static methods of the class.
2. Class Lock:\
Class level lock or static lock is used when you want to synchronize static methods or block of code. This lock is associated with the class itself, not with individual instances. When a thread acquires a class level lock, it prevents any other thread from accessing any static synchronized methods or blocks in that class.

In summary, the difference between a class lock and an object lock is the scope of the lock. An object lock only locks the object the lock is associated with, while a class lock locks all objects of the class. So, if you have multiple instances of a class, an object lock will only lock the object it's associated with, allowing other instances to execute their synchronized blocks of code concurrently. A class lock will prevent concurrent execution of the synchronized code block in all instances of the class.

### 19. What is future and completableFuture?
- Future:\
In Java, java.util.concurrent.Future is an interface that represents the result of an asynchronous computation. It provides methods to check if the computation is complete, to wait for its completion, and to retrieve the result of the computation. The result can only be retrieved when the computation has completed; the get method will block if the computation has not yet completed.

- CompletableFuture:\
java.util.concurrent.CompletableFuture is a Future that may be explicitly completed by setting its value and status, and may be used as a CompletionStage, supporting dependent functions and actions.
It provides a large number of methods for creating, chaining, and combining multiple Futures. It also allows you to manually complete a Future.

### 20. what is ThreadLocal?
ThreadLocal is a class in Java that provides thread-local variables. These variables differ from their normal counterparts in that each thread that accesses one (via its get or set method) has its own, independently initialized copy of the variable. ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread.

The ThreadLocal class in Java enables you to create variables that can only be read and written by the same thread. Thus, even if two threads are executing the same code, and the code has a reference to a ThreadLocal variable, then the two threads cannot see each other's ThreadLocal variables.

### 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
Practice code in MavenProject/multithreading

### 22. Read those interview questions and pick some important questions to this home work.
- What is the difference between t.start() and t.run()?\
t.start starts a new thread to excute the task(run()) t.run() excute the task in the current thread.

- What is the differecence between Callable and Runnbale?\
runnable has no return; callable has return

- Can we use new Thread(lambda)? is it equal to implement Runnable? Why?\
  Yes, if there is only one interface with @FunctionalInterface, we can use lambda;
  in Runnable, only have one interface run();
- When the thread terminated?\
if there is no infinite loop, it will terminated when task is done.

- Which one is popular between Runnable and Callable? Why?\
Callable should be more popular, because it got return value.

- What is the difference between synchronized(this) and synchronized(Singleton.class)?
1. synchronized(this):\
When a thread enters a synchronized instance method or a synchronized block with "this", it acquires the intrinsic lock for that method's object and releases it when the method returns. The lock acquisition/release occurs even if the return was caused by an uncaught exception.\
Synchronization on this (an instance lock) means that only one thread can access the synchronized instance methods (or synchronized blocks synchronized on the same instance) of the object at a time. Other threads attempting to access these methods/blocks on this instance will be blocked until the lock is released. However, these other threads can still access synchronized static methods of the class, or synchronized instance methods/blocks of other instances of the class.
2. synchronized(Singleton.class):\
Synchronized on Singleton.class (a class lock) means only one thread can access the synchronized static methods (or synchronized blocks synchronized on Singleton.class) of the class at a time, regardless of the instance. If another thread tries to access a static synchronized method while a thread holds the lock on the class, it will be blocked until the thread holding the lock releases it.

- What is the main difference between synchronized and ReentrantLock?\
1. Flexibility: \
ReentrantLock provides a more flexible locking mechanism compared to synchronized. With ReentrantLock, a lock can be acquired in one method and released in another method. However, with synchronized blocks, the lock is automatically released when the synchronized block or method ends, and it can't be manually controlled.
2. Condition Variables:\
ReentrantLock provides a Condition interface, which has await() and signal() methods similar to wait() and notify() methods in synchronized keyword usage. However, Condition provides more control as we can create multiple Condition objects for a single lock, each handling a different kind of event
3. Interruptible Lock Acquisition: \
ReentrantLock provides a feature that allows a thread to interrupt another thread that is waiting to acquire a lock, whereas the synchronized keyword doesn't provide this feature.
4. Fairness: \
ReentrantLock allows you to specify fairness. If set to true, the longest-waiting thread will get the lock. synchronized blocks don't provide the fairness option, and the lock acquisition order is not predictable.
5. Lock Polling and Timed Wait: \
ReentrantLock provides the tryLock method which allows lock polling - a thread can try to acquire the lock and if it's not available, do something else instead of waiting. It also has an overload which allows timed wait for lock acquisition. These features are not available with the synchronized keyword.
6. Performance: \
The synchronized keyword is easier to write and has less overhead than a ReentrantLock. This means that a synchronized block generally performs better than a ReentrantLock. However, in practice, the difference in performance is not likely to be noticeable unless there's very high contention.

- How many ways we can create a thread for task?\
1. new Thread(new Task("name"))
2. es.submit(new Task("name"))


### 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
Practice code in MavenProject/multithreading/practice/q23


### 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
Practice code in MavenProject/multithreading/practice/q24


