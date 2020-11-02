package test0805;

public class TestProduct {
    public static void main(String[] args) {
        //创建仓库对象
        RepositoryTest repositoryTest = new RepositoryTest();
        //创建并启动生产线程
        new ProdectC(repositoryTest).start();
        new ConsumerC(repositoryTest).start();
    }
}
