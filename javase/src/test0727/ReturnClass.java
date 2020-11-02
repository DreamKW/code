package test0727;

import java.util.Arrays;

public class ReturnClass {
    //基本数据类型做返回值
    public int show (char b){
        System.out.println(b);
        return 1;

    }
    public char show1 (int a){
        System.out.println("输值加一为：" + (a+1));
        return '男' ;
    }
    public  boolean show2(int [] a){
        System.out.println(Arrays.toString(a));

        return true;
    }
    //引用数据类型做返回值
    //数组
    public int [] show3(){
        int [] scores = {1,2,3};

        return  scores;
    }
    //String
    public String show4(Person [] p){
        for (Person ps:
                p             ) {
            System.out.println(ps.height +"   "+ ps.weight);
        }

        return "hello";
    }
    //对象
    public Person show5(Person p){
        System.out.println(p.height);

        Person a = new Person();
        a.weight = 120;
        a.height = 175;
        return new Person();

    }
    //对象数组
    public Person[] show6( String s){
        System.out.println(s);

        Person[] ps = new Person[2];
        ps[0]= new Person();
        ps[0].height = 170;
        ps[0].weight = 125;
        ps[1] = new Person();
        ps[1].height = 180;
        ps[1].weight = 150;
        return ps;
    }



}
