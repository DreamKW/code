package test0729;

public class Card {
    private  int cid;
    private  double money;
    //    一个人一张卡
    private  Person person;
//    一张卡多个人使用
    private Person[] persons;
    public Card(){
        System.out.println("我是Card的构造方法");
    }
}
