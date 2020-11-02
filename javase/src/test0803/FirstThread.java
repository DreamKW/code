package test0803;

public class FirstThread extends  Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+ i + "在执行任务");
        }
    }

}
