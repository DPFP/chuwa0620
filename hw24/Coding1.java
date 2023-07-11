package hw24;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Coding1 {
    public static void main(String[] args) {
        Object lock = new Object();
        AtomicInteger count = new AtomicInteger(0);
        Thread t1 = new Thread(new MyPrinter(lock, count));
        Thread t2 = new Thread(new MyPrinter(lock, count));
        t1.start();
        t2.start();

    }
}
class MyPrinter implements Runnable{
    private Object lock;
    private AtomicInteger count;
    public MyPrinter(Object lock, AtomicInteger count){
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        while (count.get() <=10){
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + " is printing: "+count.getAndIncrement());
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        synchronized (lock) {
            lock.notify();
        }
    }
}
class OddEvenPrinter {
    private static final Lock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static int number = 1;
    private static final int MAX_COUNT = 10;
    private static boolean isOddPrinted = false;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (number <= MAX_COUNT) {
                lock.lock();
                try {
                    if (number % 2 == 1) {
                        System.out.println("Odd: " + number);
                        number++;
                        isOddPrinted = true;
                        evenCondition.signal();
                    } else {
                        try {
                            oddCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (number <= MAX_COUNT) {
                lock.lock();
                try {
                    if (number % 2 == 0) {
                        System.out.println("Even: " + number);
                        number++;
                        isOddPrinted = false;
                        oddCondition.signal();
                    } else {
                        try {
                            evenCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}