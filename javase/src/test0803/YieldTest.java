package test0803;

public class YieldTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+"HELLO");
        }
    }

    public static void main(String[] args) {
        YieldTest yt1 = new YieldTest();
        FirstThread firstThread = new FirstThread();
        yt1.start();
        firstThread.start();
    }
}
