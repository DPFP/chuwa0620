package c02_basic_thread_handling;

/**
 * 一旦所有的用户线程都运行完毕，那么守护线程是无法阻止JVM退出的。即当程序只剩下守护线程的时候程序就会退出。
 */
public class Daemon {
    public static void main(String[] args) {
        Thread tPpl = new Thread(new People());
        Thread tGod = new Thread(new God());
        Thread tGod2 = new Thread(new God());

        tGod.setDaemon(true);
        tGod.start();
        tPpl.start();
        tGod2.setDaemon(true);
        tGod2.start();
        System.out.println("Main out");
    }
}

class People implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ppl live");
        }
        System.out.println("People thread end");
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("上帝守护你");
        }
    }
}
