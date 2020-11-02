package Test0818;

import java.io.*;
//字节流
public class TestInput {
    public static void main(String[] args) throws IOException {
        //创建需要读取的文件对象
        File file = new File("D:\\class0818.txt");
        file.createNewFile();
        //创建FileInputStream对象，即为file对象与流对象进行关联
        FileInputStream fis = new FileInputStream(file);//读进内存 从里(i)到外
        FileOutputStream fos = new FileOutputStream(file,true );//写到 从外(o)到里 写到硬盘
        String str = "b";

//        int a = 110;
        try{
            fos.write(str.getBytes());

//            fos.write(a);//存进去 读出来为 d
        }finally {
            fos.flush();//刷新
            fos.close();
        }
//        fos.write(str.getBytes());
//        fos.close();

        int len = 0;
        try {
            while ((len = fis.read()) != -1){
                System.out.print((char)len + "     ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fis.close();
        }


    }
}
