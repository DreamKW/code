package test0723;

public class SwitchWeek {
    public static void main(String[] args) {

        Week week = Week.周一;
        switch (week){
            case 周一:
                System.out.println("上课了");
                break;
            case 周三:
                System.out.println("马上放假了");
        }
    }


}
