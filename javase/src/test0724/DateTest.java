package test0724;

public class DateTest {
    public static void main(String[] args) {
        float [] zhangsan = new float[2];
        zhangsan[0]=60.5f;
        zhangsan[1]=170f;
//        zhangsan[2]=170f;  数组越界

        Person a1 = new Person();
        a1.weight = 120;
        a1.height = 175;
        Person a2 = new Person();
        a2.weight = 96;
        a2.height = 165;
        Person [] person = {a1,a2};

        System.out.println("张三的体重："+person[0].weight+"   张三的身高："+person[0].height);
    }
}
