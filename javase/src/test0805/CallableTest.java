package test0805;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es =  Executors.newSingleThreadExecutor();
        Future f = es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("我在使用Runnable执行任务");
            }
        });

        System.out.println("runnable:" + f.get());
        f = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("我在使用Callable执行任务");
                return "测试成功了";
            }
        });
        System.out.println("callable:" + f.get());
        es.shutdown();
    }

}
