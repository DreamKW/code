package test0814;

import java.util.Objects;

public class Stuent implements Comparable <Stuent> {

    String name;
    int age;

    public Stuent() {
    }

    public Stuent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stuent stuent = (Stuent) o;
        return age == stuent.age &&
                Objects.equals(name, stuent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
//    public int compareTo(Stuent o) {
//        if (this != null && o != null){
//            if (this.getName().compareTo( o.getName())>0){
//                return 1;
//            }else if (this.getName().compareTo( o.getName()) < 0){
//                return -1;
//            }
//        }else {
//            new RuntimeException("对象不能为空...");
//        }
//        return 0;
//    }

    public int compareTo(Stuent o) {
        if (this != null && o != null){
            if (this.getAge() > o.getAge()){
                System.out.println(this.getName() + "的年龄比" + o.getName() +"大哦");
                return 1;
            }else if (this.getAge() < o.getAge() ){
                System.out.println(this.getName() + "的年龄比" + o.getName() +"小呀");
                return -1;
            }
        }else {
            new RuntimeException("对象不能为空...");
        }
        System.out.println(this.getName() + "：我们的年龄一样哇   ->" + o.getName());

        return 0;
    }
}
