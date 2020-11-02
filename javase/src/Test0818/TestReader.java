package Test0818;

import java.io.*;

public class TestReader {
    public static void main(String[] args) throws IOException {
        //创建需要读取的文件对象
        File file = new File("D:\\class0818.txt");
        //创建Reader 管道
        FileReader fileReader = new FileReader(file);//输出
        FileWriter fileWriter = new FileWriter(file,true);//写入
        fileWriter.write("哈哈");
        fileWriter.flush();
        fileWriter.close();
        //设置一个字符数组 大小为1024最为合适
        char [] c = new char[1024];
        int len = 0;
        while((len = fileReader.read(c)) != -1){
            System.out.println(new String(c,0,len));
        }
        fileReader.close();
    }

}
