1. The volatile keyword in Java is used to indicate that a variable's value may be modified by multiple threads simultaneously. It ensures that the variable is always read from and written to the main memory, rather than from thread-specific caches, ensuring visibility across threads.

2. ```java
   // create thread using Thread
   public class MyThread extends Thread{
     @Override
     public void run(){
       System.out.println("Running");
     }
   }
   
   Thread t = new Thread();
   t.start();
   
   // create thread using Runnable
   public class MyRunnable implements Runnable{
     @Override
     public void run(){
       System.out.println("Running")；
     }
   }
   
   Thread t = new Thread(new MyRunnable);
   t.start();
   
   // create thread using ExcecutorService
   ExecutorService executor = Executor.newFixedThreadPool(5);
   executor.submit(new myRunnable());
   ```

3. Runnable is a interface that has Run function without return value. Callable is an interface with Run function that can return a generic type.

4. t.start() will run the task in another thread, t.run() will use current thread to proferm the run function.

5. Using Runnable is better, since Java only support multiple inhertiance by interface, which means the class can also implement something else than Runnable interface. And Runnable also support lambda syntax and threadpool.

6. Thread is not always running, they have to wait for cpu timeslot or certain condition to run and pause, So in java thread can have many status of New, WAITING, RUNNING, READY, TERMINATED, BLOCKED, TIMED WAITING

7. Wait() method releases lock during Synchronization.** **Sleep() method does not release the lock on object during Synchronization

8. Deadlock is a situation wthere different threads trying to aqcuire the key that is hold by ohters. And now will release  the holding key without getting another key, thus no thread can process forward.

9. All the threads in the same program share the same memory space. If an object is accessible to various threads then these threads share access to that object's data member and thus communicate each other. The second way for threads to communicate is by using thread control methods like notify(), notifiyall(), interrupt().

10. Join() method means a new thread is now been attached to current thread, current thread will have to wait until the attached thread to complete to process forward.

11. A yield() method is a static method of Thread class and it can stop the currently executing thread and will give a chance to other waiting threads of the same priority.

12. A Thread Pool is a collection of worker threads that efficiently execute asynchronous callbacks on behalf of the application. The thread pool is primarily used to reduce the number of application threads and provide management of the worker threads.

13. The Executor Framework contains a bunch of components that are used to efficiently manage multiple threads. There are FixedThreadPool, CachedThreadPool and SignleThread Executor.

14. The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks.

15. The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations. All the atomic classes have the get() and set() methods that work on the volatile variable. The method works the same as read and writes on volatile variables.

16. Concurrent collections in java provides thread safe collection like Concurrent hashmap block queue.

17. Reentrantlock, ReentrantReadWriteLock, StampedLock

18. 

    1. Object Level Locks − It can be used when you want non-static method or non-static block of the code should be accessed by only one thread. 
    2. Class Level locks − It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime.

19. A Future is used as a reference to the result of an asynchronous computation. It provides an `isDone()` method to check whether the computation is done or not, and a `get()` method to retrieve the result of the computation when it is done.

    CompletableFuture is used for asynchronous programming in Java. Asynchronous programming is a means of writing *non-blocking* code by running a task on a separate thread than the main application thread and notifying the main thread about its progress, completion or failure.This way, your main thread does not block/wait for the completion of the task and it can execute other tasks in parallel.

20. The *TheadLocal* construct allows us to store data that will be accessible only by a specific thread.

    Let's say that we want to have an *Integer* value that will be bundled with the specific thread.

21. Done

22. What is thread starvation

    Thread starvation is basically a situation or condition where a thread won’t be able to have regular access to shared resources and therefore is unable to proceed or make progress. This is because other threads have high priority and occupy the resources for too long. This usually happens with low-priority threads that do not get CPU for its execution to carry on. 