package Test0818;

import java.io.*;

public class TestVip {
    public static void main(String[] args) throws IOException {
        //创建需要复制的对象
        File old = new File("d:\\jixian.mp4");

        File newfile = new File("d:\\class0818\\jx.mp4");
        //创建输入流输出流 即创建对象  创建管道关联对象
        //输入流输出流 相当与 内存而言
        FileInputStream fis = new FileInputStream(old);//从里到外 读出来
        FileOutputStream fos = new FileOutputStream(newfile);// 从外到里 写进去
        //将输入流添加到缓冲流中
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte [] s = new byte[1024];
        int len = 0 ;
        while((len = bis.read(s)) != -1){
            bos.write(s,0,len);
            System.out.println(len);
        }
        //先关缓冲 再关输入输出流  从外向里关  bos 为外 fos 为里
        bos.close();
        fos.close();
        bis.close();
        fis.close();


    }
}
