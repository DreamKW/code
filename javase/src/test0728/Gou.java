package test0728;

public class Gou {
    private int  age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gou (int a){
        this.age=age;
        System.out.println("真");
    }
     Gou(String s){

    }
    protected Gou(char a){

    }
    private Gou(){

    }
    public  void Gou (){
        System.out.println("假");
    }

    public static void main(String[] args) {
        Gou g = new Gou();
    }
}
