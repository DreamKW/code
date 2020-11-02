package Test0818.home;

import java.io.*;

public class TestCopy {
    public static void main(String[] args) throws IOException {
        File old = new File("d:\\stus.txt");
        File newf = new File("d:\\class0818\\stus1.txt");
        FileInputStream fis  = new FileInputStream(old);
        FileOutputStream fos = new FileOutputStream(newf);
        BufferedInputStream bis  = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte [] b = new byte[1024];
        int len = 0 ;
        while ((len = bis.read(b)) != -1){
            bos.write(b,0,len);
            System.out.println(len);
        }
        bos.close();
        fos.close();
        bis.close();
        fis.close();
    }
}
