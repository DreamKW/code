package test0807;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

public class TestArray {
    public static void main(String[] args) {

        //规定好数组的数据类型
        Class intc = int.class;
        //创建数组实例，数据类型以及长度
        Object object = Array.newInstance(intc,3);
        //给数组元素赋值
        Array.set(object,0,20);
            for (int i = 0; i < 3; i++) {
                Array.set(object,i,i);
            }
        //获取数组元素的值
        System.out.println(Array.get(object,0));
        for (int i = 0; i < 3; i++) {
            System.out.println(Array.get(object,i));
        }


    }

}
