package test0730;

public class Cat extends Pet {

    @Override
    public void eat() {

        System.out.println(name +"猫开始吃饭了");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.show();
    }

}
