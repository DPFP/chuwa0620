package chuwa.learning;

public class TwoThreads {
    public static volatile Integer number = 1;

    public static Object lock = new Object();
    public static class MyThread implements Runnable{
        int id;

        MyThread(int id){
            this.id = id;
        }

        @Override
        public void run() {
            while (number <= 10) {
                synchronized (lock) {
                    System.out.println(""+id+":"+number);
                    number++;
                    lock.notify();
                    if (number <= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void run(){
        Thread thread1 = new Thread(new MyThread(1));
        Thread thread2 = new Thread(new MyThread(2));
        thread1.start();
        thread2.start();
    }
}



