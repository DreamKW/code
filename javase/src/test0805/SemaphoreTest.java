package test0805;

import java.util.concurrent.Semaphore;

public class SemaphoreTest extends Thread {
    String name;
    //定义一个信号量
    Semaphore semaphore;
    public SemaphoreTest (){

    }
    //定义一个有参构造方法
    public SemaphoreTest(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }
    @Override
    public synchronized void run() {
        //判断是否有信号量
        if(semaphore.availablePermits() > 0){
            System.out.println(name + "有位置 ，快抢");
        }else {
            System.out.println(name + "没有位置了,等等");
        }
        try {
            semaphore.acquire();//拿到许可证
            System.out.println(name +"抢到了，可以吃了");
            Thread.sleep(1000);
            System.out.println(name + "吃完了 ");
            semaphore.release();//释放许可证
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //创建一个信号量对象
        Semaphore s = new Semaphore(2);//参数规定好信号量的数量
        //创建线程对象执行这个任务
        new SemaphoreTest("a",s).start();
        new SemaphoreTest("b",s).start();
        new SemaphoreTest("c",s).start();
        new SemaphoreTest("d",s).start();
    }
}
