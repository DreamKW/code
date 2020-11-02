package Test0818;

import java.io.*;
//文件传输
public class TestTansfor {

    public static void main(String[] args) throws IOException {
        File old = new File("d:\\jixian.mp4");
        File newfile = new File("d:\\class0818\\jx.mp4");
        FileInputStream fis = new FileInputStream(old);
        FileOutputStream fos = new FileOutputStream(newfile);
        int len = 0;
        while ((len = fis.read() ) != -1){
            fos.write(len);
            System.out.println(len);
        }
        fos.flush();
        fos.close();
        fis.close();
    }
}
