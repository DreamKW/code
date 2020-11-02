package test0724;

public class Student {

        //属性
        private String name;
        private String sex;
        private String address;
        private int age;
        private long phone;

    public Student(String name, String sex, String address, int age, long phone) {
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.age = age;
        this.phone = phone;
    }
//构造方法
    public void eat(){
            System.out.println("我不想吃米饭啦.....");
        }
        public  void study(){
            System.out.println("学习不是学习的特有特征！！！");
        }
//ToString 显示不是地址而是对象的内容
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}

