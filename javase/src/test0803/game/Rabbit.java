package test0803.game;

public class Rabbit  extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i+=10) {
            Thread.yield();
            try {
                Thread.sleep((long)Math.random() * 10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("兔子跑了"+ i + "米");
            if (i == 100){
                System.out.println("兔子到终点了");
            }
        }
    }
}
