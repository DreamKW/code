package test0730;

public class FirstInterfaceImpl implements FirstInterface{
    public void eat(){
        System.out.println("我真的吃了哦 ");
    }

    @Override
    public void show() {
        System.out.println("让我开始展示吧");
    }
}
