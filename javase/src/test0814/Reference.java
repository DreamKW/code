package test0814;

import java.lang.ref.SoftReference;

public class Reference {
    public static void main(String[] args) {
        String str = ("a,b,c");
        SoftReference<String> softReference = new SoftReference<String>(str);
    }
}
