package Test0818.home;

import java.io.*;

public class TestArray {
    public static void main(String[] args) throws IOException {
        // 创建一个ByteArray输出流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 将以上的流封装在Data流中
        DataOutputStream dos = new DataOutputStream(baos);
        // 通过dos对象写入数据
        dos.writeInt(18);
        dos.writeDouble(3.141522);
        dos.writeUTF("Hello");
        // 关闭管道
        dos.close();
        baos.close();
        // 读取信息
        // 创建输入流对象进行读操作
        // 因为是通过DATAoutput进行了写的操作，而我们现在需要读取的就是刚刚写的数据，所以需要从管道dis中读取baos对象
        byte[] byes = baos.toByteArray();
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(byes));
        // 读取数据
        System.out.println(dis.readDouble() + " " + dis.readUTF() + dis.readInt());
        dis.close();
    }
}
