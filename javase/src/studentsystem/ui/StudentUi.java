package studentsystem.ui;

import studentsystem.service.StudentService;
import studentsystem.serviceImpl.ReflectSvImpl;
import studentsystem.entity.Student;
import studentsystem.entity.UserEnum;
import studentsystem.util.EmailTest;
import test0722.JudgeNo;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class StudentUi {
    //反射创建对象
//    Class c = StudentService.class;
//    StudentService sv = (StudentService) c.newInstance();
    StudentService sv =  new ReflectSvImpl();
    Student stuf = null;
    Scanner input = new Scanner(System.in);

    public StudentUi() throws Exception {
    }

    public void registed() throws Exception {
        System.out.println("---------------注册-------------");
        System.out.println("--------请输入你的姓名：----------");
        String sname = input.next();
        System.out.println("--------请输入你的年龄：----------");
        int sage = JudgeNo.judge();
        System.out.println("--------请输入你的邮箱：----------");
        String semail;
        while (true){
             semail = input.next();
            if (!EmailTest.emailTest(semail)){
                System.out.println("邮箱格式不合格请重新输入：");
            }else{
                break;
            }
        }

        int rolenu ;
        String role = null;
        boolean flagu = true;
        while (flagu){
            System.out.println("----------------角色对应的数字：----------");
            System.out.println("---------1.学生--2.老师--3管理员---------");
            System.out.println("---------请输入您的选择：");
            rolenu = JudgeNo.judge();
            for(UserEnum u: UserEnum.values()){
                if (u.index == rolenu){
                    role = u.role;
                    flagu = false;
                    System.out.println("-----------角色选择成功-------------");
                    break;
                }
            }
            if (flagu == true){
                System.out.println("没有您选择的角色！！！");
            }
        }


        String ss;

        while (true){
            System.out.println("--------请输入你的密码：----------");
            ss = input.next();
            System.out.println("-------请再次输入你的密码：-------");
            String smi2 = input.next();
            if (ss.equals(smi2)){
                break;
            }else{
                System.out.println("两次输入密码不同，密码重新设置");
            }
        }
        int s =0 ,a = 0,f =0;
        for (int m = 0; m < ss.length(); m++) {
            char c = ss.charAt(m);
            if (Character.isDigit(c)){//判断是否为数字
                s = 1;
            }else if (Character.isLetter(c)){//判断是否为字母
                a = 1;
            }else{//其他字符
                f = 1;
            }
        }
        int g = s + a +f;
        if(g ==3){
            System.out.println("您的密码等级为高！");
        }else if(g == 2){
            System.out.println("您的密码等级为中等");
        }else{
            System.out.println("您的密码等级为低");
        }

        //找到对应的constructor对象
//        Class c = StudentService.class; //在上面定义为成员变量了
//        Constructor constructor = c.getConstructor(new Class[]{String.class,int.class,int.class,String.class,String.class});
//       Student stu = (Student) constructor.newInstance(new Object[]{sname,snum,sage,role,ss});
            Student stu = new Student(sname,sage,semail,role,ss) ;

        if( sv.addStuent(stu)){
            System.out.println("-------------注册成功-------------");
        }else {

            System.out.println("-------------人数已满-------------");
            System.out.println("-------------注册失败-------------");

        }




    }
    public void login() throws Exception {
        int c1 = 0;
        String stuname ;
        while (c1 < 3){
            System.out.println("---------------登录----------------");
            System.out.println("---------请输入你的姓名：----------");
            stuname = input.next();
            System.out.println("---------请输入你的密码：----------");
            String stumi= input.next();
            System.out.println("------------正在登录-------------");
//
//            Constructor constructor = c.getConstructor(new Class[]{int.class,String.class});
//            Student stu = (Student) constructor.newInstance(new Object[]{stunum,stumi});
             Student stu = new Student(stuname,stumi);
             stuf =  sv.loginStuent(stu);
            if( stuf  != null){
                System.out.println("------------登录成功-------------");
                home();
                break;
            }else{
                System.out.println("登录失败，您剩余"+(2-c1)+"次机会");
                c1 += 1;
            }
            if ( c1 ==  3){
                break;
            }
        };
    }
    public void home() throws Exception {
       if (stuf.getSap().equals(UserEnum.学生.toString())){
            new HomeStuUi().home();
       }else if (stuf.getSap().equals(UserEnum.老师.toString())){
           new HomeTeacherUi().home();
       }else if (stuf.getSap().equals(UserEnum.管理员.toString())){
           new HomeAdministratorUi().home();
       }else {
           System.out.println("您没有设置角色 设置角色");
       }


    }
    public void delete() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        String sname ;
//        StudentServiceImpl sv = new StudentServiceImpl();
        System.out.println("请输入你要删除人的姓名：");
        sname= input.next();
        Student stux = new Student(sname) ;

        sv.delete(stux);
    }
    public void select() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String sname ;

        System.out.println("请输入你的姓名：");
        sname = input.next();
        Student stu = new Student(sname) ;
        sv.selectXx(stu);

    }
    public void update() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println("-----------5.信息修改---------");
        System.out.println("--------请输入你姓名：----------");
        String snameup = input.next();
        System.out.println("--------请输入你新的年龄：----------");
        int sageup = JudgeNo.judge();
        System.out.println("--------请输入你新的专业：----------");
        String sapup = input.next();
        String ssup;

        while (true){
            System.out.println("--------请输入你新的密码：----------");
            ssup = input.next();
            System.out.println("-------请再次输入你的密码：-------");
            String ssup2 = input.next();
            if (ssup.equals(ssup2)){
                break;
            }else{
                System.out.println("两次输入密码不同，密码重新设置");
            }
        }

        Student stuup = new Student(snameup,sageup,sapup,ssup) ;
        if(sv.update(stuup)){
            System.out.println("-------------修改成功-------------");
        }else {
            System.out.println("-------------修改失败-------------");
        }
    }

    public void dianMin() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        System.out.println("======随机点名=======");
        System.out.println("同学：");
        sv.dianMin();
        int no =1;
        while(no == 1){
            System.out.println("是否继续选取下一名学生： 1 继续  0  退出");
            no = studentsystem.util.JudgeNo.judge();
            while(no != 1 && no !=0){
                System.out.println("请输入正确的选项：");
                no = studentsystem.util.JudgeNo.judge();
            }
            System.out.println("同学：");
            sv.dianMin();
        }

    }
}
