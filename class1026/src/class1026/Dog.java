package class1026;

public class Dog {
    private String name;
    private int age;

    public Dog() {
    }
// 顺序不一样调用不同的构造方法
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("name + age");
    }
    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("age + name");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }
}
