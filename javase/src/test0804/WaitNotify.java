package test0804;

public class WaitNotify {
    volatile boolean flag = false;
    Object obj   = new Object();
    Thread man = new Thread(
            () ->{
                while (true){
                    if (flag){
                        System.out.println("取鸡蛋");
                        flag = false;
                        synchronized (obj){
                            obj.notify();
                        }
                    }else {
                        System.out.println("没有鸡蛋啦");
                        //同步obj对象  表示取得鸡蛋和鸡下的蛋是一个对象
                        synchronized (obj) {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
    );

    //定义鸡
    Thread hen = new Thread(
            ()->{
                while (true){
                    if (flag){
                        System.out.println("有鸡蛋，抓紧时间取哦");
                        synchronized (obj){
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }else{
                        System.out.println("下蛋啦");
                        flag = true;
                        //唤醒取蛋的人
                        synchronized (obj){
                            obj.notify();
                        }
                    }
                }
            }
    );

    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify();
        wn.hen.start();
        wn.man.start();
    }
}
