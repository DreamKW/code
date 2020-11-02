package test0819;

import java.io.*;
import java.nio.channels.FileChannel;

public class TestNio {
    public static void main(String[] args) throws IOException {
        File old = new File("d:\\stus.txt");
        File newf = new File("d:\\class0818\\stus2.txt");
        FileInputStream fis  = new FileInputStream(old);
        FileOutputStream fos = new FileOutputStream(newf);
        //使用NIO来完成对象的传输
        FileChannel read = fis.getChannel();
        FileChannel write = fos.getChannel();
        read.transferTo(0,read.size(),write);
        write.close();
        fos.close();
        read.close();
        fis.close();
    }
}
