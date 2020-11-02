package test0803;

public class TestThread {
    public static void main(String[] args) {
        //创建Thread 对象
        //第一种方式创建的类本身就是Thread对象，所以直接创建实例即可
        FirstThread ft = new FirstThread();
        ft.setPriority(10);
        ft.start();
        //第二种方式因为实现了Runnable接口，所以它本身不是一个Thread对象，需要将此对象转化
        SecondThread st = new SecondThread();
        Thread second = new Thread(st,"second");
        //设置优先级
        second.setPriority(1);
        second.start();
    }
}
