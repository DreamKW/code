package studentsystem.daoIimpl;

import studentsystem.dao.StuDao;
import studentsystem.entity.Student;

import java.util.HashSet;
import java.util.Iterator;

public class SetStuDao implements StuDao {
    static Integer i = 0;
    static HashSet<Student> studentHashSet ;
    static {
        studentHashSet = new HashSet<>(3);
        Student student = new Student("admin",12,"111@qq.com","管理员","1230");
        studentHashSet.add(student);
    }

    @Override


    public   boolean addStudent(Student student) {
        boolean flag = false;
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

            studentHashSet.add(student);
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
        Iterator it = studentHashSet.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
        return flag;
    }

    @Override
    public Student loginStudent(Student stu) {
        return null;
    }

    @Override
    public void selectXx(Student stu) {

    }

    @Override
    public void delete(Student stux) {

    }

    @Override
    public boolean update(Student stuup) {
        return false;
    }

    @Override
    public void dianMin() {

    }
}
