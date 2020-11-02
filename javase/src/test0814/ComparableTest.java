package test0814;

import java.util.Arrays;

public class ComparableTest {
    public static void main(String[] args) {
        Stuent [] stuents = new Stuent[4];

        stuents[1] = new Stuent("B",12);
        stuents[2] = new Stuent("C",13);
        stuents[0] = new Stuent("A",12);
        stuents[3] = new Stuent("D",03);



        Arrays.sort(stuents);//排序了
        for (Stuent s :
                stuents) {
            System.out.println(s.getAge() +  " " + s.getName());
        }
    }
}
