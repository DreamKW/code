package test0803;

public class SecondThread implements  Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i + "第二个线程在执行任务");
        }
    }
}
