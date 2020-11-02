package book.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int u_id;
    private String u_name;
    private List<Brooor> brooorList;

    public User() {
        this.brooorList = new ArrayList<>();
    }

    public User(String u_name) {
        this.u_name = u_name;
        this.brooorList = brooorList;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public List<Brooor> getBrooorList() {
        return brooorList;
    }

    public void setBrooorList(List<Brooor> brooorList) {
        this.brooorList = brooorList;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", brooorList=" + brooorList +
                '}';
    }


}
