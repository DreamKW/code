package book.entity;

import java.util.ArrayList;
import java.util.List;

public class Type {
    private int t_id;
    private String t_name;
    private List<Book> bookList;

    public Type() {
        this.bookList = new ArrayList<>();
    }

    public Type( String t_name) {

        this.t_name = t_name;
        this.bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
