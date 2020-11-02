package Test0818.home;

import java.io.*;

public class TestPush {
    //回推流
    public static void main(String[] args) throws IOException {
        String str = "aejkeaallooaaoidisa";
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        PushbackInputStream pis = new PushbackInputStream(bais);
        int len = 0;
        while ((len = pis.read()) != -1){
            System.out.print((char)len);
            if ('a' == len){
                pis.unread('A');
            }
        }
    }
}
