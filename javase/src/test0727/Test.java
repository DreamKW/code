package test0727;

public class Test {
    public static void main(String[] args) {
        ReturnClass rs = new ReturnClass();

        System.out.println(rs.show('a'));
        //        Person p = new Person(180,140);
//        System.out.println("" + rs.show5(p));


        Person [] p = new Person[2];
        p[0] = new Person();
        p[0].height = 170;
        p[0].weight = 120;
        p[1] = new Person(150,80);
        System.out.println(rs.show4(p));


        p = rs.show6("来人啦");
        for (Person ps:p
             ) {
            System.out.println(ps.height +"   " + ps.weight);
        }

    }
}
