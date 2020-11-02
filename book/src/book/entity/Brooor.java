package book.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Brooor {
    private int bor_id;
    private Date bordate;
    private Book book;
    private User user;
    private List<Remand>remandList;

    public Brooor(){
        remandList = new ArrayList<>();
    }

    public Brooor(Date bordate) {
        this.bordate = bordate;
        this.remandList = new ArrayList<>();
    }
}
