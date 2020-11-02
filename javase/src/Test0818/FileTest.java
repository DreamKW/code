package Test0818;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/class0818.doc");
        file.createNewFile();
        file = new File("d:/class0818");
        file.mkdir();
        System.out.println("====测试list====");
        String [] files = file.list();//得到的是名字
        for (String f :
                files) {
            System.out.println(f);
        }
        System.out.println("====测试listfiles===");
        File [] files1 = file.listFiles();//得到的是文件
        for (File f :
                files1) {
            System.out.println(f.getName() + "是目录吗？"+ f.isDirectory());//测试是否是目录
        }
        System.out.println("====FilenameFiler=过滤====名字=");
        files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //当无处下手时 打印 dir name  测试 记忆方法
//                System.out.println("==============");
//                System.out.println(dir);
//                System.out.println(name);
//                System.out.println("==============");
                if (name.endsWith((".docx")) || name.endsWith(".bmp")){
                    return true;
                }
                return false;
            }
        });
        for (String f :
                files) {
            System.out.println(f);
        }
        System.out.println("======FileFilter=文件=====");
      files1 = file.listFiles(new FileFilter() {
          @Override
          public boolean accept(File pathname) {
              if (pathname.isDirectory())
                  return true;
              return false;
          }
      });
        for (File f :
                files1) {
            System.out.println(f.getName() + "是目录吗？"+ f.isDirectory());//测试是否是目录
        }

    }
}
