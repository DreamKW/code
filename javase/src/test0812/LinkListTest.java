package test0812;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkListTest {
    public static void main(String[] args) {
        ArrayList a1 = new ArrayList();
        LinkedList a  = new LinkedList();
        a.add(a);
        a.addFirst(1);
        a.addLast(3);
        a.get(1);
        a.getFirst();
        a.getLast();
        LinkedList<String> ll = new LinkedList();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        System.out.println("第一种");
        for (int i = 0; i <ll.size(); i++) {
            System.out.print(ll.get(i));
        }
        System.out.println();
        System.out.println("第二种");
        for (String s :
                ll) {
            System.out.print(s);
        }
        System.out.println();
        System.out.println("第三种");
        Iterator it = ll.iterator();
        while (it.hasNext()){
            System.out.print(it.next());
        }
        ll.removeFirst();
        ll.remove("k");
    }
}
