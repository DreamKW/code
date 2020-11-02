package test0810.home;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PaiXu {
    int c ;
    public static void main(String[] args) {
        PaiXu paiXu = new PaiXu();
        paiXu.add("A");

    }

    public void add(String s) {
        String[] a = new String[10];
        a[0] = "A";
        a[1] = "T";
        a[2] = "C";
        a[3] = "X";
        a[4] = "F";
        a[5] = "H";

        for (int i = 0; i < a.length; i++) {
            if (a[i] != null ){
                c++;
            }
        }
        System.out.println(c);
        System.out.println(  "b".compareToIgnoreCase("a"));
        a[c]=s;
        for (int i = 0; i < c ; i++) {
            String value = a[i+1];
            int j = i;
            for (; j>=0 && a[j].compareToIgnoreCase(value)>0; j--) {
//
//                Integer.parseInt(a[j]) > Integer.parseInt(value)

                a[j+1] = a[j];
            }
            a[j+1] = value;
            System.out.println(Arrays.toString(a));

        }
        System.out.println(Arrays.toString(a));
    }
}






//

//        for (int i = 0; i < c; i++) {
//        //小于第一个数
//        if (Integer.parseInt(a[i]) > Integer.parseInt(string)) {
//        for (int j = c; j < 0  ; j--) {
//        a[j] =a[j-1];
//        }
//        //  i<s<i+1
//        } else if (Integer.parseInt(string) < Integer.parseInt(a[i + 1])) {
//
//
//        }
//
//
//        }