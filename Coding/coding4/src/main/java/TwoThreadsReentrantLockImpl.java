import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadsReentrantLockImpl {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int number = 1;

    public static class MyThread extends Thread {
        public void run() {
            while (number <= 10) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    ++number;
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

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }
}
