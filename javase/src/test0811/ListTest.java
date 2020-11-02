package test0811;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
//        List list = new ArrayList();
//        if (2 > 3)
//            System.out.println(1);
//                System.out.println(2);
//        System.out.println(3);
        System.out.println(new ListTest().run(3));

    }

    public boolean run (int a ){
        for (int i = 0; i < a; i++) {
            System.out.println(i);
            return  false;
        }
        return false;
    }

}
