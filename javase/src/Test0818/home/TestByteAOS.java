package Test0818.home;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class  TestByteAOS {
    public static void main(String[] args) {
        byte [] b = {'a','v','r',3,'=','c'};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(b,1,4);
        byte [] c = baos.toByteArray();

        ByteArrayInputStream bInput = new ByteArrayInputStream(c);
        int d = 0 ;
        while ((d = bInput.read()) != -1){
            System.out.println((char)d);
        }
        System.out.println("==========");

        for (int i = 0; i < c.length; i++) {
            System.out.println((char)b[i]);
        }
    }
}
