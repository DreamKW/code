package class1027;



public class Target {
    public String getTar( String name){
        System.out.println("我是真正的目标" + name);
        System.out.println(9/0);
        return name;
    }
}
