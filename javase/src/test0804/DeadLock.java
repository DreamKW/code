package test0804;

public class DeadLock {
    Object obj1 = new Object();
    Object obj2 = new Object();
    class Thread1  extends  Thread{
        @Override
        public void run() {
            synchronized (obj1){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1，锁了obj1");
                synchronized (obj2){
                    System.out.println("线程1，锁了obj2");
                }
            }
        }
    }
    class Thread2  extends  Thread{
        @Override
        public void run() {
            synchronized (obj2){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2，锁了obj2");
                synchronized (obj1){
                    System.out.println("线程2，锁了obj1");
                }
            }
        }
    }

    public static void main(String[] args) {

        DeadLock dl = new DeadLock();
        dl.new Thread1().start();
        dl.new Thread2().start();
    }
}
