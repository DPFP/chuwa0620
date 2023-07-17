import java.util.concurrent.locks.ReentrantLock;

public class PrintNumber {
    public static int value = 1;
    static ReentrantLock re = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrinterRunnable());
        Thread t2 = new Thread(new PrinterRunnable());
        Thread t3 = new Thread(new PrinterRunnable());
        t2.start();
        t1.start();
        t3.start();
    }

    static class PrinterRunnable implements Runnable {
        @Override
        public void run() {
            try {
                re.lock();
                for (int i = 0; i < 10; i++) {
                    if (value == 23)
                        break;
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                re.unlock();
            }
        }

    }
}
