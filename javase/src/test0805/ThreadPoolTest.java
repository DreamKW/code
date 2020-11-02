package test0805;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//线程池
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,1, TimeUnit.SECONDS,new LinkedBlockingDeque<>(2));
        //执行任务
        threadPoolExecutor.execute(new Mythread());
        threadPoolExecutor.execute(new Mythread());
//        threadPoolExecutor.execute(new Mythread());
//        threadPoolExecutor.execute(new Mythread());
        System.out.println(threadPoolExecutor.getPoolSize());
        // threadPoolExecutor.execute(new Mythread());
       // threadPoolExecutor.execute(new Mythread());
        Thread.sleep(4000);
        System.out.println(threadPoolExecutor.getPoolSize());
        //关闭线程池
        threadPoolExecutor.shutdown();
    }

}
