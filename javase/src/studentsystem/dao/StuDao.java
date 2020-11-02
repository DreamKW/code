package studentsystem.dao;


import studentsystem.entity.Student;

public interface StuDao {
    public   boolean addStudent(Student student);
    public Student loginStudent(Student stu);
    public void selectXx(Student stu);
    public void delete(Student stux);
    public boolean update(Student stuup);
    void dianMin();
}
