package test0730.homeinterface;

public class Printer {

    //这两个相当 学生类里的name age 属性
    Papper papper;
    Color color;

    public Printer(){

    }
    public Printer(Papper papper,Color color){
        this.papper = papper;
        this.color = color;
    }


    public void printer(Papper papper,Color color){
        System.out.println("使用"+color.color()+"墨水，在"+papper.size()+"纸上打印");
    }
}
