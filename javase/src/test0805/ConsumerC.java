package test0805;

public class ConsumerC extends  Thread {
    //定义仓库
    RepositoryTest repositoryTest;
    //定义产品
    char c ;
    public ConsumerC (){

    }
    public  ConsumerC(RepositoryTest repositoryTest){
        this.repositoryTest = repositoryTest;
    }
    //定义消费的方法
    public void consume() throws InterruptedException {

    }

    @Override
    public void run() {
        do {
            try {
                c = repositoryTest.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (c != 'D');
    }
}
