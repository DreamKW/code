package test0807;

public class Student {
    private String name;
    private int age;
    public String sex;
    //定义一个get 方法 只有此get方法 没有相关属性
    public int getScore(){
        return 100;
    }
    //定义一个set 方法 只有此set方法 没有相关属性
    public void setBirthday(String name){
        System.out.println(name + "没有");
    }

    Student() {
    }


    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void show(String name,int age) {
        System.out.println(name +  +age + "测试啦");
    }
}
