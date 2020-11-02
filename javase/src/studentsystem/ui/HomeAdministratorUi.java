package studentsystem.ui;

import test0722.JudgeNo;

public class HomeAdministratorUi {
    public  void home(){
        int c =1;
        while( c== 1) {
            System.out.println("-----------管理员主页----------");
            System.out.println("-----------1.删除专业----------");
            System.out.println("-----------2.添加专业----------");
            System.out.println("-----------3.返回上级----------");
            int b = JudgeNo.judge();
            switch (b){
                case 1:{
                    System.out.println("删除专业\n\n\n\n\n");
                    break;
                }
                case 2:{
                    System.out.println("添加专业\n\n\n\n\n");

                    break;
                }
                case 3:{
                    System.out.println("返回上级\n\n");
                    c = 0;
                    break;
                }
            }
            if (c == 0 ){
                break;
            }

        }




    }




}
