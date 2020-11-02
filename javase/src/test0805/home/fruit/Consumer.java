package test0805.home.fruit;
//消费者线程
public class Consumer extends Thread {
    RepositoryFruit repositoryFruit;
    String fruit;
    public Consumer (){};
    public Consumer ( RepositoryFruit repositoryFruit){
        this.repositoryFruit = repositoryFruit;
    }

    @Override
    public void run() {
        do{
            fruit = repositoryFruit.consumer();
        }while (!fruit.equals("芒果"));
    }
}
