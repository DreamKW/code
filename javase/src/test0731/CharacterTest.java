package test0731;

public class CharacterTest {
    public static void main(String[] args) {
        Character a ='1';
        String str = "SDFGH145lkjh";
        for (int i = 0; i < str.length(); i++) {
//            System.out.print(str.charAt(i)+" ");
            char c = str.charAt(i);
            if (Character.isDigit(c)){
                System.out.println(c +"是数字！！！");
            }
        }

    }
}
