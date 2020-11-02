package class1026;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Boy {
    private String name;
    private int age;
    private  Dog dog;
    private String address;
    private Product product;
    private List list;
    private List<Dog> dogList;
    private Set set;
    private Map map;
    private Map<Integer,Dog> dogMap;

//    public Boy(String name, int age, Dog dog, String address) {
//        this.name = name;
//        this.age = age;
//        this.dog = dog;
//        this.address = address;
//    }

    public Boy(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }


    public Boy() {
    }
    public Boy(String name,int age){
        this.age = age;
        this.name = name;
    }
    public Boy(String name, int age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
    }
    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }


    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public void setDogList(List<Dog> dogList) {
        this.dogList = dogList;
    }

    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Map<Integer, Dog> getDogMap() {
        return dogMap;
    }

    public void setDogMap(Map<Integer, Dog> dogMap) {
        this.dogMap = dogMap;
    }

}
