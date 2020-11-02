package test0724;

public class Test {
    public static void main(String[] args) {
        //基本数据类型的值传递
        ClassTest ct  = new ClassTest();
        int age = 10;
        ct.test(age);//调用方法的时候的参数是实际参数

        //引用数据类型 字符串 的值传递
        String name = "kkww";
        ct.test(name);
        //传递 对象 的参数
        Person p = new Person();
        p.weight = 140;
        p.height = 178;
        ct.test(p);
        //数组 做参数
        int [] score = {1,2,4};
        ct.test(score);
        //对象数组 做参数
        Person [] people =  new Person[2];
        people[0] = new Person();
        people[0].height = 165;
        people[0].weight = 95;
        people[1] = new Person();
        people[1].height = 175;
        people[1].weight = 125;
        ct.test(people);

    }
}
