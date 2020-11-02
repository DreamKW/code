package test0806;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
//        创建一个Timer对象
        Timer timer = new Timer();
//        调用执行的方法
        timer.schedule(new Mytask(),1000,2000);
    }
}
//创建一个任务内部类
class Mytask extends TimerTask{
    @Override
    public void run() {
        System.out.println("执行任务");
    }
}