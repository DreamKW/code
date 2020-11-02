package test0804.home;

public class Eat {
    Object k1 = new Object();
    Object k2 = new Object();
    Object k3 = new Object();
//    Object k4 = new Object();
    class  eat1  extends Thread{
        @Override
        public void run() {
            synchronized (k1){
                System.out.println("p1拿了左手边的筷子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (k2){
                    System.out.println("p1拿了右手边的筷子");
                }

            }
        }
    }
    class eat2 extends Thread{
        @Override
        public void run() {
            synchronized (k2){
                System.out.println("p2拿了左手边的筷子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (k3){
                    System.out.println("p2拿了右手边的筷子");
                }
            }
        }
    }

    class eat3 extends  Thread{
        @Override
        public void run() {
            synchronized (k3){
                System.out.println("p3拿了左手边的筷子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (k1){
                    System.out.println("p3拿了右手边的筷子");

                }

            }
        }
    }

    public static void main(String[] args) {
        Eat eat = new Eat();
        eat.new eat1().start();
        eat.new eat2().start();
        eat.new eat3().start();
    }
}
