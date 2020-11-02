package test0805.home.fruit;

//生产者线程
public class Prodect extends Thread{
    public RepositoryFruit repositoryFruit;
    String [] fruits = {"苹果","香蕉","橘子","草莓","芒果"};
    public Prodect (){};
    public Prodect(RepositoryFruit repositoryFruit){
        this.repositoryFruit= repositoryFruit;
    }


    @Override
    public void run() {
        for (int j = 0; j < fruits.length ; j++) {
            repositoryFruit.product(fruits[j]);
        }

    }
}
