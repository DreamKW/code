package Test0817;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/class08170000.jpg");
        file.createNewFile();
        file = new File("d:/class081700000");
        file.mkdir();
//        file.delete();
//        file = new File("d:/class081700000/001");
//        file.mkdir();
//        file.delete();
    }
}
