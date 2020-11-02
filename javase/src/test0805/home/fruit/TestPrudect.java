package test0805.home.fruit;

public class TestPrudect {
    public static void main(String[] args) {
        RepositoryFruit repositoryFruit = new RepositoryFruit();
        new Consumer(repositoryFruit).start();
        new Prodect(repositoryFruit).start();
    }
}

