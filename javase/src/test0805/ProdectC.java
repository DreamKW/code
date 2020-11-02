package test0805;

public class ProdectC extends  Thread {
    //定义仓库
    public RepositoryTest repositoryTest;
    //无参构造方法
    public ProdectC (){

    }
    public ProdectC(RepositoryTest repositoryTest){
        this.repositoryTest = repositoryTest;
    }
    //定义一个方法，用来进行产品的生产
//    public void prodect() throws InterruptedException {
//
//    }

    @Override
    public void run() {
        for (char   i = 'A'; i <'D' ; i++) {
            try {
                repositoryTest.product(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
