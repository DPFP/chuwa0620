package chuwa.learning;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadsReentrantlockImplementation{
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int number = 1;

    public static class MyThread extends Thread{
        int id;
        MyThread(int id){
            this.id = id;
        }
        public void run() {

                while (number <= 10) {
                    lock.lock();
                    try {
                        System.out.println(""+id+":"+number);
                        number++;
                        condition.signal();
                        if (number <= 10) {
                            condition.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

        }
    }

    public static void run(){
        MyThread thread1 = new MyThread(1);
        MyThread thread2 = new MyThread(2);
        thread1.start();
        thread2.start();
    }

}
