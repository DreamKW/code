package studentsystem.entity;


public enum UserEnum {
    学生(1,"学生"),老师(2,"老师"),管理员(3,"管理员");
      public  String role;
      public int index;
    private UserEnum(int index , String role){
        this.role = role;
        this.index = index;
    }
}
