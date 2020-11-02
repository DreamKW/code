package test0730;

public class TestPet {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.name = "花花";
        pet.eat();
        pet.test();
//        Pet pet1 = new Dog();
        pet = new Dog();
        pet.name = "旺财";
        pet.eat();
        pet.test();
//        抽象类不可以创建实例
//        pet = new Pet();
//        匿名内部类 不是创建实例
//        pet = new Pet("gouzao") {
//            //类体内容
//            @Override
//            public void eat() {
//                System.out.println(name+"来啦");
//            }
//        };
        pet.eat();
        pet.test();
    }
}
