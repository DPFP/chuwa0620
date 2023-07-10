import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinterWithLock {
    private static ReentrantLock re = new ReentrantLock();
    private static Condition oddCondition = re.newCondition();
    private static Condition evenCondition = re.newCondition();
    public static int value = 1;

    public static void main(String[] args) {
    }

    static class EvenPrintRunnbale implements Runnable {

        @Override
        public void run() {
            try {
                re.lock();
                while (value <= 10) {
                    while (value % 2 != 0) {
                        evenCondition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    oddCondition.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                re.unlock();
            }
        }
    }

    static class OddPrintRunnable implements Runnable {

        @Override
        public void run() {
            try {
                re.lock();
                while (value < 11) {
                    while (value % 2 == 0) {
                        oddCondition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    evenCondition.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                re.unlock();
            }
        }
    }
}
