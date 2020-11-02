package test0813;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>() ;
        for (int i = 0; i < 12 ; i++) {
            list.add("b" + i);
        }
        Collections.shuffle(list);
        System.out.println(list);
        for (int i = 0; i < 12 ; i++) {
            list.add("b" + i);
        }
        System.out.println("逆序");

    }
}
