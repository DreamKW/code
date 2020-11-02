package test0813;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class CollextionTest {
    public static void main(String[] args) {
        Vector v = new Vector();

        List<String> list = new ArrayList<>();
        list.add("aab");
        list.add("bbb");
        list.add("aac");
        list.add("aaa");

        System.out.println("排序前");
        for (String s :
                list) {
            System.out.print(s+ " ");
        }

        System.out.println();
        System.out.println("排序后");
        Collections.sort(list);
        for (String s :
            list    ) {
            System.out.print(s + " ");
        }

        System.out.println("逆序");
        Collections.reverse(list);
        for (String s :
                list) {
            System.out.print(s + " ");
        }
    }
}
