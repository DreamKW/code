package test0728;

public class TestAnimal {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.name = "虎子";
        dog.age = 6;
        dog.eat();
//        System.out.println("============");
//        Cat cat = new Cat();
//        cat.age = 2;
//        cat.name = "mimi";
//        cat.eat();
//        System.out.println("===========");
//        GrandCat grandCat = new GrandCat();
//        grandCat.name = "小小猫";
//        grandCat.eat();
//
//
//        System.out.println("=========");
//
//        Cat cat = new Cat();
//        cat.age = 2;
//        cat.name = "mimi";
//        cat.eat();
        Animal animal = new Cat();//父类引用子类对象
        animal.name = "猫猫多态";
        animal.eat();


        //使用子类特有的方法  向下转型
        if(animal instanceof  Cat){
            Cat cat = (Cat) animal;
            cat.show();
        }
        ((Cat) animal).show();


        animal = new Dog();
        animal.name = "狗狗多态";
        animal.eat();

    }
}
