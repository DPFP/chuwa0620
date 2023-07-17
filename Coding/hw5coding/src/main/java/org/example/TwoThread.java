package org.example;

public class TwoThread {
    public static final Object lock = new Object();
    private static int count = 1;
    public static class PrintThread implements Runnable {
        private int id;

        public PrintThread(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            while(count <= 10) {
                synchronized (lock) {
                    System.out.println(id + " : " +count++);
                    lock.notify();
                    try{
                        if(count < 11) {
                            lock.wait();
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintThread(1)).start();
        new Thread(new PrintThread(2)).start();
    }
}
