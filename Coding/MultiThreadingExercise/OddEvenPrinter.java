import java.lang.Object;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class OddEvenPrinter {
    private static final Object monitor = new Object();
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int value1 = 1;
    private static int value2 = 1;

    public static void main(String[] args) {
        SychronizedRunnable runnable = new SychronizedRunnable();
        LockRunnable runnable2 = new LockRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable2).start();
        new Thread(runnable2).start();
    }

    // sychronized keyword
    static class SychronizedRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (value1 <= 10) {
                    System.out.println("Sychronized method " + Thread.currentThread().getName() + ": " + value1++);
                    monitor.notify();
                    try {
                        if (value1 < 11) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // lock
    static class LockRunnable implements Runnable{
        @Override
        public void run(){
            try{
                Thread.sleep(1000);
                lock.lock();
                while(value2 <= 10){
                    System.out.println("Lock method " + Thread.currentThread().getName() + ": " + value2++);
                    condition.signal();
                    if(value2 <= 10){
                        condition.await();
                    }
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally{
                lock.unlock();
            }
        }
    }
}
