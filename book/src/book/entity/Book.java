package book.entity;


import java.util.ArrayList;
import java.util.List;

public class Book {
    private int b_id;
    private Type type;
    private String b_name;
    private Double price;
    private List<Brooor> brooorList;

    public Book(int b_id, Type type, String b_name, Double price) {
        this.b_id = b_id;
        this.type = type;
        this.b_name = b_name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "b_id=" + b_id +
                ", type=" + type +
                ", b_name='" + b_name + '\'' +
                ", price=" + price +
                ", brooorList=" + brooorList +
                '}';
    }

    public Book() {
        this.brooorList = new ArrayList<>();
    }

    public Book(Type type, String b_name, Double price) {
        this.type = type;
        this.b_name = b_name;
        this.price = price;
        this.brooorList = new ArrayList<>();
        this.type.getBookList().add(this);
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Brooor> getBrooorList() {
        return brooorList;
    }

    public void setBrooorList(List<Brooor> brooorList) {
        this.brooorList = brooorList;
    }
}
