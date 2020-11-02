package test0813.home;

import java.util.Arrays;

public class ReverseTest {


    public static void main(String[] args) {
        reverseM("qwer");
    }


    public static void reverseM(String str){
        int c= str.length();
        char[] y = new char[c];
        char[] h = new char[c];
        for (int i = 0; i < c; i++) {
            y[i] = str.charAt(i);
        }
        for (int i = 0; i < c; i++) {
            h[i] = y[c-i-1] ;
        }
        String []  s = {"1","2","4"};
        String strh = String.join("",s);
        System.out.println(strh);
        System.out.println(Arrays.toString(h));
        System.out.println(h);


    }

}

