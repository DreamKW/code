package test0805;

public class RepositoryTest {
    //产品
    char c ;
    boolean flag;
    //生产者
    public synchronized  void product(char c ) throws InterruptedException {
        if (flag){
            System.out.println("仓库中有产品，快卖了");
            wait();
        }
        this.c = c ;
        flag = true;
        System.out.println(this.c + "生产好了，赶紧卖吧");
        notify();
    }

    //消费者
    public synchronized char consume() throws InterruptedException {
        if (!flag){
            System.out.println("仓库没产品，不能卖了");
            wait();
        }
        flag = false ;
        System.out.println(this.c + "卖出去了，再生产吧！");
        notify();
        return this.c;
    }
}
