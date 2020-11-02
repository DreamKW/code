package testXian;

public class Duo implements Runnable{

    @Override
    public  synchronized void run() {
        Yun.yun();
    }
}
