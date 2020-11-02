package studentsystem.daoIimpl;

import studentsystem.dao.StuDao;
import studentsystem.entity.Student;
import studentsystem.util.JudgeNo;

import java.io.*;
import java.util.HashMap;
import java.util.Random;

public class MapStuDao implements StuDao {
//    static Integer i = 0;
//    static int q = 0;
    public static HashMap<Integer, Student> studentHashMap ;

//    min=(a<b)?a:b;


    @Override

    public   boolean addStudent(Student student) {
         Integer ap= (studentHashMap == null)?0:studentHashMap.size();

        boolean flag = false;

        //验证从前面传过来的学生对象没有 sunm属性 set之后 这个对象增加了 sunm属性
//        student.setSnum(123);

//        实现学生ID的自动生成 不能重复
        Random random = new Random();
        int p = 1;
        while(  p ==1){
            String id ="";
            for (int i = 0; i < 8; i++) {
                String a = String.valueOf(random.nextInt(10));
                id += a;
            }
            int c = 1;
            for (int j = 0; j < ap; j++) {
                if (studentHashMap.get(j).equals(id)){
//                    System.out.println("添加失败！！此id 已经存在 请重新生成id");
                    c =0;
                    break;
                }
            }

            if (ap == 0 ||  c == 1){
                student.setSnum(id);
                p = 0;
            }
        }

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

            studentHashMap.put(ap++,student);
            flag = true;
            //因为map 无法获取 限制容量 so 用上面的例子
//            for (int r = 1; r < studentHashMap.size(); r++) {
//                if (studentHashMap.get(r) == null ){
//                    studentHashMap.put(r,student);
//
//                    flag = true;
//                    break;
//                }
//            }
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
        for (int j = 0; j <ap; j++) {
            if (studentHashMap.get(j) != null && !"".equals(studentHashMap.get(j)) ){
                System.out.println(studentHashMap.get(j));
            }
        }
        return flag;
    }

    @Override

    public Student loginStudent(Student stu) {
//        boolean flog = false;

        Student stur = null;
        /**
         * for 循环里返回true 外面为什么得不到
         */
        for (int j = 0; j < studentHashMap.size(); j++) {
            if(studentHashMap.get(j) != null && !"".equals(studentHashMap.get(j))){
                if (stu.getSname().equals(studentHashMap.get(j).getSname())  && stu.getSs().equals(studentHashMap.get(j).getSs())) {
//                    flog = true;
                    stur =studentHashMap.get(j);
                    break;
                }
            }
        }
        return stur;
    }

    @Override
    public void selectXx(Student stu) {
        if (stu != null && !"".equals(stu)){
            for (int q = 0; q <studentHashMap.size(); q++) {
                if (studentHashMap.get(q) != null && !"".equals(studentHashMap.get(q))){
                    if (studentHashMap.get(q).getSname().equals(stu.getSname())){
                        System.out.println(studentHashMap.get(q));
                        // 这些应该在 StudentUi select 方法里 但是要修改返回值太麻烦
                        System.out.println("是否显示密码？ 1 是  2 否");
                        int xm = JudgeNo.judge();
                        if (xm == 1){
                            System.out.println(studentHashMap.get(q).getSs());
                        }

                        break;

                        //                System.out.println("学号："+st[k].getSnum()+"  姓名："+st[k].getSname()+ " 年龄："+st[0].getSage()+" 专业："+ st[0].getSap());
                    }else {
                        if (q == (studentHashMap.size()-1) ){
                            System.out.println("没有此用户！！");
                            break;
                        }
                    }
                }
                if (q == (studentHashMap.size()-1) ){
                    System.out.println("没有此用户！！");

                }
            }

        } else {
            System.out.println("用户未输入！");
        }
    }

    @Override
    public void delete(Student stux) {
        for (int k = 0; k <studentHashMap.size(); k++) {
            if (studentHashMap.get(k) != null  && !"".equals(studentHashMap.get(k))){
                if (studentHashMap.get(k).getSname().equals(stux.getSname())){
                    studentHashMap.remove(k);
                    System.out.println("删除成功.....");
                    break;
//                    i--;
                }else {
                    if (k == (studentHashMap.size()-1)) {
                        System.out.println("没有此用户！！");
                        break;
                    }
                }
            }

        }

    }

    @Override
    public boolean update(Student stuup) {
        boolean flag = false;
//        int o = 0;
        if (stuup != null && !"".equals(stuup)){
            for (int i = 0; i < studentHashMap.size(); i++) {
                if (studentHashMap.get(i).getSname().equals(stuup.getSname()) ){
                    studentHashMap.get(i).setSname(stuup.getSname()) ;
                    studentHashMap.get(i).setSage(stuup.getSage()) ;
                    studentHashMap.get(i).setSap(stuup.getSap());
                    studentHashMap.get(i).setSs(stuup.getSs());
                    flag = true;
                    break;

                }else{
                    if (i == studentHashMap.size()-1){
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
    public  void dianMin() {
            Random random = new Random();
            System.out.println(studentHashMap.get(random.nextInt(studentHashMap.size())).getSname());
    }
}
