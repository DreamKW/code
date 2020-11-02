package test0804;

import java.util.concurrent.TimeUnit;

public class Hen {
    //定义一个标识 表示是否有鸡蛋
    public boolean flag = false;
    Thread men = new Thread(
            () -> {
                while(true){
                    if(flag){
                        System.out.println("有鸡蛋");
                        flag = false;
                    }else{
                        System.out.println("没了");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
    );
    Thread hen = new Thread(
            () -> {
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = true;
                }
            }
    );

    public static void main(String[] args) {
        Hen hen = new Hen();
        hen.men.start();
        hen.hen.start();
    }
}
