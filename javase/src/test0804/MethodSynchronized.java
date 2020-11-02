package test0804;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class MethodSynchronized {
    //任务
    public synchronized void test1(){
        System.out.println("test1在执行！！！");
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test1执行：" +  i);
        }
    }
    public synchronized void test2(){
        System.out.println("test2在执行！！！");
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test2执行：" +  i);
        }
    }
    public synchronized void test3(){
        System.out.println("test3在执行！！！");
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test3执行：" +  i);
        }
    }

    public static void main(String[] args) {
        MethodSynchronized ms = new MethodSynchronized();
        //直接创建线程对象 执行任务即可
//        Runnable a = () -> ms.test1();
//        Thread 对象 参数为Runnable 对象
        new Thread(() ->ms.test1()).start();
        new Thread(() ->ms.test2()).start();
        new Thread(() ->ms.test3()).start();
    }
}
