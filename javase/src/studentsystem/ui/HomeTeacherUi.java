package studentsystem.ui;

import studentsystem.util.DianMin;
import test0722.JudgeNo;



public class HomeTeacherUi {
    public  void home() throws Exception {
        int c = 1;
        while (c == 1){
            System.out.println("--------------老师主页-------------");
            System.out.println("-----------1.删除学生信息----------");
            System.out.println("-----------2.添加学生信息----------");
            System.out.println("-----------3.查询学生信息----------");
            System.out.println("-----------4.上课点名系统----------");
            System.out.println("------------0.返回上一级----------");
            int b = JudgeNo.judge();
            StudentUi studentUi = new StudentUi();
            switch (b){
                case 1:{
                    //bug 当前用户不能删除自己
                    System.out.println("删除学生信息:");
                    studentUi.delete();
                    break;
                }
                case 2:{
                    System.out.println("添加学生信息\n\n\n\n\n");
                    studentUi.registed();
                    break;
                }
                case 3:{
                    System.out.println("查询学生信息:");
                    studentUi.select();
                    break;
                }
                case 4:{
                    System.out.println("点名系统：");
                    studentUi.dianMin();
                    break;
                }
                case 0:{
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
