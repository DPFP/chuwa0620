package practice.q23;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEventPrinterReen {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int val = 1;

    public static void main(String[] args) {
        OddEventPrinterSync.PrintRunnable runnable = new OddEventPrinterSync.PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                while (val <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + val++);
                    condition.signalAll();
                    if (val < 11) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
