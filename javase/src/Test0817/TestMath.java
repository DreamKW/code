package Test0817;

import java.math.BigInteger;

public class TestMath {
    public static void main(String[] args) {
//        BigInteger bigInteger = new BigInteger();
        System.out.println('1');
        System.out.println("1"+"2");


        System.out.println(Math.abs(-3));//绝对值
        Math.max(3,2);
        Math.min(3,4);
        int [] age = {1,4,2,5,77,88,0};
        int max = age[0];
        for (int i = 1; i < age.length; i++) {
          max = Math.max(age[i],max);
        }
        System.out.println(max);

        Math.random();//随机数
        for (int i = 0; i < 100; i++) {
            int no = (int)(Math.random()*10);
            System.out.println(no);
            if (no == 9){
                System.out.println("您中奖了");
                break;
            }
        }

        System.out.println(37/10);
        System.out.println(37.0/10);
        System.out.println(37/10.0);//有小数结果则是小数 为double类型 要为float类型 加f
        System.out.println(9.0/4);//2.25
        System.out.println(37.00/10.0); //3.7 结果与37.00 小数点后两个0无关
        System.out.println(25.0/5); //5.0
        System.out.println(10.0/3); //3.3333333333333335
        System.out.println(10.0f/3);//3.3333333
        System.out.println(age.getClass().toString());//获取数据类型


        System.out.println((Math.random()*100)/10);
    }
}
