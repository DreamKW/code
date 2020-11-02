package test0728;

public class OverLoad {
    public  int add( int a ){
        return a;
    }
    public  String add(String a){
        return a;
    }

//    public  String add(int a){//不能重写只有返回值不同的方法
//        return "a";
//    }

    public int add(int a,int b){
        return a+b;
    }
    public  int add(int a, int b, int c){
        return  a+b+c;
    }
    //    public  void add(int a, int b, int c){
//        System.out.println(a+b+c);
//    }
    public void add(String a , String b){
        System.out.println(a + b);
    }
}
