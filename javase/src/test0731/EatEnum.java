package test0731;

public enum EatEnum {

    烧烤("烧烤",1),肉("肉",2),火锅("火锅",3);
    private String name;
    private int index;

     EatEnum (String name,int index){
        this.name = name;
        this.index = index;
    }
    public static String getName(int index){
        for(EatEnum e: EatEnum.values()){
            if (e.index == index){
                return e.name;
            }
        }
        return "没有这道菜";
    }

    public static void main(String[] args) {

        System.out.println(EatEnum.getName(1));
    }
}
