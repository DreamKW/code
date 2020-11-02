package test0806;

public class ThreadLocalTest {
    //定义两个ThreadLocal 变量  定义两个是为了说明ThreadLocal<> 泛型
    ThreadLocal<String> threadLocal1 = new ThreadLocal();
    ThreadLocal<Long> threadLocal2 = new ThreadLocal();
    //定义一个set方法 用来给两个变量赋值
    public void set(){
        threadLocal1.set(Thread.currentThread().getName());
        threadLocal2.set(Thread.currentThread().getId());
    }
    //获取到threadLocal1 变量的值
    public String get1(){
        return threadLocal1.get();
    }

    public Long get2 (){
        return threadLocal2.get();
    }

    public static void main(String[] args) throws InterruptedException {
        //创建当前对象
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        //调用set方法，给两个本地变量赋值
        threadLocalTest.set();
        //显示两个本地变量的值
        System.out.println("初始本地变量1的值" +        threadLocalTest.get1());
        System.out.println("初始本地变量2的值" +        threadLocalTest.get2());
       Thread thread =  new Thread(){
            @Override
            public void run() {
                //再次给两个本地变量赋值
                threadLocalTest.set();
                System.out.println("修改后本地变量1的值" +        threadLocalTest.get1());
                System.out.println("修改后本地变量2的值" +        threadLocalTest.get2());
            }
        };
       thread.start();
       thread.join();
        System.out.println("回到主线程本地变量1的值" +        threadLocalTest.get1());
        System.out.println("回到主线程本地变量2的值" +        threadLocalTest.get2());

    }
}
