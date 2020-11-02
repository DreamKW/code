package studentsystem.daoIimpl;


import studentsystem.dao.StuDao;
import studentsystem.entity.Student;
import studentsystem.util.JudgeNo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ReflectDaoImpl implements StuDao {


/*    Class c1 = Student.class;
    Constructor constructor = c1.getConstructor(new Class[]{String.class,int.class,String.class});
    //创建studnet对象
    student = (Student) constructor.newInstance(new Object[]{"a",1,"v"});
   数组不是永久存储 项目重启数据清零
    static ArrayList<Student> students ;*/
    static Student[] st;
    static {
/*
    static int i = 0;
            students = new ArrayList<>();
            Student stu1 = new Student("admin",1230,10,"管理员","1230");
            students.add(stu1);*/


            st = new Student[3];
            st[0]= new Student("admin",24,"11111111","111@qq.com","管理员","1111");

        }
//        Class c = Student.class;
//        try {
//            Constructor constructor = c.getConstructor(new Class[]{String.class,int.class,int.class,String.class,String.class});
//            st[0] = (Student) constructor.newInstance(new Object[]{"admin",1230,10,"管理员","1230"});
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }



    public ReflectDaoImpl() throws IllegalAccessException, InstantiationException {
    }

    /**
     * 注册
     * @param student
     */
    public   boolean addStudent(Student student) {
        boolean flag = false;

        Random random = new Random();
        int p = 1;
        while(  p ==1){
            String id ="";
            for (int i = 0; i < 8; i++) {
                String a = String.valueOf(random.nextInt(10));
                id += a;
            }
            int c = 1;
            for (int j = 0; j < st.length; j++) {
                if (st[j] != null && "".equals(st[j])){
                    if (id.equals(st[j].getSnum())){
//                    System.out.println("添加失败！！此id 已经存在 请重新生成id");
                        c =0;
                        break;
                    }
                }

            }

            if (  c == 1){
                student.setSnum(id);
                p = 0;
            }
        }
//        int i = 0;
        //将信息添加到数组
            if (student != null && !"".equals(student)){
//                得到现在数组中的人数
//                for (int j = 0; j <st.length; j++) {
//                    if (st[j] != null && !"".equals(st[j]) ){
//                     ++i;
//                    }
//                }
//判断人数是否已满
//                if(i < st.length){
                    for (int r = 1; r < st.length; r++) {
                        if (st[r] == null ){
                            st[r] = student;

                            flag = true;
                            break;
                        }
                    }
//                    人数已满输出学生信息
//                }
//                else {
//                    System.out.println("班级人数已满..");
//                    for (int j = 0; j <st.length; j++) {
//                        if (st[j] != null && !"".equals(st[j]) ){
//                            System.out.println(st[j]);
//                        }
////                System.out.println("用户名："+ stu[i].getName()+" 密码："+stu[i].getPwd());
//                    }
//                    return false;
//                }
            }else {
                System.out.println("没有学生对象传入!!!!");
                flag = false;
            }
            //输出学生信息
            for (int j = 0; j <st.length; j++) {
                if (st[j] != null && !"".equals(st[j]) ){
                    System.out.println(st[j]);
                }
            }
            return flag;
    }





    /**
     * 登录
     * @param stu
     * @return
     */
    public Student loginStudent(Student stu) {
//        boolean flog = false;

        Student stur = null;
        /**
         * for 循环里返回true 外面为什么得不到
         */
        for (int j = 0; j < st.length; j++) {
            if(st[j] != null && !"".equals(st[j])){
                if (stu.getSname().equals(st[j].getSname()) && stu.getSs().equals(st[j].getSs())) {
//                    flog = true;
                    stur = st[j];
                    break;
                }
            }
        }
        return stur;
    }

    /**
     * 查找
     * @param stu
     */
    public void selectXx(Student stu) {
        if (stu != null && !"".equals(stu)){
            for (int q = 0; q <st.length; q++) {
                if (st[q] != null && !"".equals(st[q])){
                    if (st[q].getSname().equals(stu.getSname()) ){
                        System.out.println(st[q]);
                        // 这些应该在 StudentUi select 方法里 但是要修改返回值太麻烦
                        System.out.println("是否显示密码？ 1 是  2 否");
                        int xm = JudgeNo.judge();
                        if (xm == 1){
                            System.out.println(st[q].getSs());
                        }

                        break;

    //                System.out.println("学号："+st[k].getSnum()+"  姓名："+st[k].getSname()+ " 年龄："+st[0].getSage()+" 专业："+ st[0].getSap());
                    }else {
                        if (q == (st.length-1) ){
                            System.out.println("没有此用户！！");
                            break;
                        }
                    }
            }
                if (q == (st.length-1) ){
                    System.out.println("没有此用户！！");

                }
        }

        } else {
            System.out.println("用户未输入！");
        }
    }

    /**
     * 删除
     * @param stux
     */

    public void delete(Student stux) {
        for (int k = 0; k <st.length; k++) {
            if (st[k] != null  && !"".equals(st[k])){
                if (st[k].getSname() .equals(stux.getSname()) ){
                    st[k]=null;
                    System.out.println("删除成功.....");
                    break;
//                    i--;
                }else {
                    if (k == (st.length-1)) {
                        System.out.println("没有此用户！！");
                        break;
                    }
                }
            }

        }

    }

    /**
     * 修改
     * @param stuup
     * @return
     */
    public boolean update(Student stuup) {
        boolean flag = false;
//        int o = 0;
        if (stuup != null && !"".equals(stuup)){
            for (int i = 0; i < st.length; i++) {
                if(st[i] != null && !"".equals(st[i])){
//                    信息修改不全
                    if (st[i].getSname().equals(stuup.getSname()) ){
                        st[i].setSname(stuup.getSname()) ;
                        st[i].setSage(stuup.getSage()) ;
                        st[i].setSap(stuup.getSap());
                        st[i].setSs(stuup.getSs());
                        flag = true;
                        break;
                }


                }else{
                    if (i == st.length-1){
                        System.out.println("输入信息错误...");
                        flag = false;
                        break;
                    }
                }

            }

        }else {
            System.out.println("输入信息为空....");
        }

        return flag;

    }

    @Override
    public void dianMin() {

    }
}














