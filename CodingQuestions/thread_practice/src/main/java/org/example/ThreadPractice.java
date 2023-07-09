package org.example;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class ThreadPractice {
    @Test
    public void PrintNum() throws InterruptedException {
        Runnable r = new NumPrinter();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(2000);
    }

    @Test
    public void OddEven() throws InterruptedException {
        Runnable r = new OddEvenPrinter();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        Thread.sleep(2000);
    }

    @Test
    public void OddEven_reentrant() {
        Runnable r = new OddEvenPrinter_reentrant();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            //
        }
    }
}

class NumPrinter implements Runnable{
    static int cnt = 1;
    static final Object lock = new Object();
    public void run(){
        synchronized (lock) {
            int count = 10;
            while (count-- > 0) {
                System.out.println(Thread.currentThread().getName() + ": " + cnt++);
            }
        }
    }
}

class OddEvenPrinter implements Runnable{
    static int cnt = 1;
    static final Object lock = new Object();
    public void run(){
        synchronized (lock){
            while(cnt <= 10){
                System.out.println(Thread.currentThread().getName() + ": " + cnt);
                cnt++;
                lock.notifyAll();
                try {
                        lock.wait();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

class OddEvenPrinter_reentrant implements Runnable{
    static int cnt = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    public void run(){
        try {
            lock.lock();

            while (cnt <= 10) {
                System.out.println(Thread.currentThread().getName() + ": " + cnt);
                cnt++;
                try {
                    condition.signalAll();
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }finally{
                lock.unlock();
        }
    }
}
