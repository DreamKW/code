package test0803.game;

public class Game {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        rabbit.start();
        Tortoise tortoise = new Tortoise();
        Thread tort = new Thread(tortoise,"乌龟");
        tort.start();
    }
}
