### 1 Explain volatile variables in java? (we also use it in Singleton)
For Java, “volatile” tells the compiler that the value of a variable must never be cached as its value may change outside of the scope of the program itself.

### 2 how to create a new thread(Please also consider Thread Pool case)?
1. extending the Thread class
2. implementing the Runnale class and use it to initialize the Thread class using new Thread(myRunnableObject)
3. implementing the Callable class
4. submitting a task to the thread pool

### 3 Difference between Runnable and Callable
A callable interface throws the checked exception and returns the result. A runnable interface, on the other hand, does not return a result and cannot throw a checked exception.

### 4 what is the diff between t.start() and t.run()?
1. When a program calls the start() method, a new thread is created and then the run() method is executed. But if we directly call the run() method then no new thread will be created and run() method will be executed as a normal method call on the current calling thread itself and no multi-threading will take place.  
2. we can’t call the start() method twice otherwise it will throw an IllegalStateException whereas run() method can be called multiple times as it is just a normal method calling. 

### 5 Which way of creating threads is better: Thread class or Runnable interface?
1. By implementing Runnable interface is a better way to create a thread in java because when we create a thread by extending Thread class, all Thread class methods are inherited while we can perform the task with the one method (run method) only. It results into overhead inheritance.
2. Other reason is that java does not support multiple inheritance in case of classes. So if we create a thread by extending the Thread class, we will not be able to extend any other class.

### 6 what is the thread status?
- NEW: A thread that has not yet started is in this state.
- RUNNABLE: A thread executing in the Java virtual machine is in this state.
- BLOCKED: A thread that is blocked waiting for a monitor lock is in this state.
- WAITING: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
- TIMED_WAITING: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
- TERMINATED: A thread that has exited is in this state.

### 7 difference between wait() and sleep() method
Wait() method releases lock during Synchronization. Sleep() method does not release the lock on object during Synchronization. Wait() should be called only from Synchronized context. There is no need to call sleep() from Synchronized context.

### 8 What is deadlock?
A deadlock is a situation where a set of processes are blocked because each process is holding a resource and waiting for another resource acquired by some other process. 

### 9 how do threads communicate with each other?
1. The first is through commonly shared data. All the threads in the same program share the same memory space. If an object is accessible to various threads then these threads share access to that object's data member and thus communicate each other.
2. The second way for threads to communicate is by using thread control methods. There are such three methods by which threads communicate for each other :
- suspend ( ): A thread can suspend itself and wait till other thread resume it.
- resume ( ): A thread can wake up other waiting thread (which is waiting using suspend() ) through its resume() method and then can run concurrently.
- join ( ) :This method can be used for the caller thread to wait for the completion of called thread.
3. The third way for threads to communicate is the use of three methods; wait(), notify(), and notifyAll(); these are defined in class Object of package java.lang. Actually these three methods provide an elegant inter-process communication mechanism to take care the deadlock situation in Java. As there is multi-threading in program, deadlock may occur when a thread holding the key to monitor is suspended or waiting for another thread's completion. If the other thread is waiting for needs to get into the same monitor, both threads will be waiting for ever. The uses of these three methods are briefed as below :
- wait ( ):This method tells the calling thread to give up the monitor and make the calling thread wait until either a time out occurs or another thread call the same thread's notify() or notifyAll() method.
- Notify ( ): This method wakes up the only one (first) waiting thread called wait() on the same object.
- notifyAll( ): This method will wake up all the threads that have been called wait( ) on the same object.

### 10 what is join() method?
Thread class provides the join() method which allows one thread to wait until another thread completes its execution. If t is a Thread object whose thread is currently executing, then t. join() will make sure that t is terminated before the next instruction is executed by the program.

### 11 what is yield() method
The yield() method is used in Java to hint the task scheduler to move the currently executing task to the Ready state and move another task or thread to the running state. The task scheduler is free to ignore the hint.

### 12 Explain thread pool
A Thread Pool is a collection of worker threads that efficiently execute asynchronous callbacks on behalf of the application. The thread pool is primarily used to reduce the number of application threads and provide management of the worker threads.

### 13 What is Executor Framework in Java, its different types and how to create these executors?
The Executor Framework contains a bunch of components that are used to efficiently manage multiple threads. It was released with the JDK 5 which is used to run the Runnable objects without creating new threads every time and also mostly re-using the already created threads.
- SingleThreadExecutor - ExecutorService executor = Executors.newSingleThreadExecutor();
- FixedThreadPool(n)+ - ExecutorService fixedPool = Executors.newFixedThreadPool(2);
- CachedThreadPool - ExecutorService executorService = Executors.newCachedThreadPool();
- ScheduledExecutor - ScheduledExecutorService scheduledExecService = Executors.newScheduledThreadPool(1);

### 14 Difference between shutdown() and shutdownNow() methods of executor
The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks. Upon termination, an executor has no tasks actively executing, no tasks awaiting execution, and no new tasks can be submitted.

### 15 What is Atomic classes? when do we use it?
The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations. All the atomic classes have the get() and set() methods that work on the volatile variable. The method works the same as read and writes on volatile variables.  
Suitable for calculator and incrementor.

### 16 What is the cocurrent collections?
Concurrent collections (e.g. ConcurrentHashMap), achieve thread-safety by dividing their data into segments. Concurrent collections are much more performant than synchronized collections, due to the inherent advantages of concurrent thread access.

### 17 what kind of locks you know?
ReadWriteLock, ReentrantLock, StampedLock

### 18 What is the difference between class lock and object lock?
Object Level Locks − It can be used when you want non-static method or non-static block of the code should be accessed by only one thread.  
Class Level locks − It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime.

### 19 What is future and completableFuture?
Future is an interface that belongs to java. util. concurrent package. It is used to represent the result of an asynchronous computation. The interface provides the methods to check if the computation is completed or not, to wait for its completion, and to retrieve the result of the computation.  
CompletableFuture is used for asynchronous programming in Java. Asynchronous programming is a means of writing non-blocking code by running a task on a separate thread than the main application thread and notifying the main thread about its progress, completion or failure.

### 20 what is ThreadLocal?
A quick and practical guide to using ThreadLocal for storing thread-specific data in Java.  
Java ThreadLocal is used to create thread local variables. We know that all threads of an Object share it's variables, so the variable is not thread safe. We can use synchronization for thread safety but if we want to avoid synchronization, we can use ThreadLocal variables.
