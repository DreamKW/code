package test0805.home;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GrabVotes implements Runnable {
    Lock lock = new ReentrantLock();
    Integer votes = 3;
    @Override
    public void run() {
        lock.lock();
            if (votes > 0 ){
                System.out.println(Thread.currentThread().getName() + "抢到票了");
                votes--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println(Thread.currentThread().getName() + "对不起没票了");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        lock.unlock();
    }

    public static void main(String[] args) {
        GrabVotes grabVotes = new GrabVotes();
        new Thread(grabVotes,"p1").start();
        new Thread(grabVotes,"p2").start();
        new Thread(grabVotes,"p3").start();
        new Thread(grabVotes,"p4").start();
    }
}
