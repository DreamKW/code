package test0804;

import java.util.concurrent.TimeUnit;

public class ThisSynchronized {

    public  void test1(){
        System.out.println("test1在执行！！！");
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test1执行：" + i);
            }
        }
    }
    public  void test2(){
        System.out.println("test2在执行！！！");
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test2执行：" + i);
            }
        }
    }
    public  void test3(){
        System.out.println("test3在执行！！！");
        synchronized (this){
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test3执行：" +  i);
        }
        }
    }

    public static void main(String[] args) {
        ThisSynchronized ts = new ThisSynchronized();
        new Thread(() -> ts.test1()).start();
        new Thread(() -> ts.test2()).start();
        new Thread(() -> ts.test3()).start();
    }
}
