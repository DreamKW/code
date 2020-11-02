package test0805;

import test0731.LamdaTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    //创建锁对象
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    public void test (){
        synchronized (this){
            System.out.println("sy锁上了");
        }
    }

    public void show (){
        //上锁 锁的是对象
        lock1.lock();
        System.out.println("我在使用锁");
        lock1.unlock();//解锁
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        lockTest.test();
        lockTest.show();
    }



}
