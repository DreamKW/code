package testXian;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Test1 {
    public static void main(String[] args) {
        //多线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,
                1, TimeUnit.SECONDS,new LinkedBlockingDeque<>(2));
        threadPoolExecutor.execute( new Thread(new Duo()));
        threadPoolExecutor.execute( new Thread(new Duo()));
        threadPoolExecutor.execute( new Thread(new Duo()));
        threadPoolExecutor.execute( new Thread(new Duo()));
//        thread.start();
        //普通
//        DuoP.run();
        threadPoolExecutor.shutdown();
    }
}
