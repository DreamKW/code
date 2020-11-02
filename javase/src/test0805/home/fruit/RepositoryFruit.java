package test0805.home.fruit;

public class RepositoryFruit {
    String fruit ;
    boolean flag;
    public synchronized void product(String fruit){
//        这里传入参数是为了显示生产好的产品
        if (flag){
            System.out.println("仓库中有产品，快卖了");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.fruit = fruit;
        flag = true;
        System.out.println(this.fruit+"生产好了，赶紧卖吧");
        notify();
    }
    public synchronized String consumer(){
        if ( !flag){
            System.out.println("没水果了");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        System.out.println(this.fruit + "卖出去了，再生产吧！");
        notify();
        //这里返回值是为了在Consumer 判断是否超出 自己定义好的水果界限 让程序停止
        return this.fruit;
    }

}
