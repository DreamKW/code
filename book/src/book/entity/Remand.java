package book.entity;

import java.util.Date;

public class Remand {
    private int re_id;
    private Date redate;
    private Brooor brooor;
    public Remand(){};
    public Remand(Date redate) {
        this.redate = redate;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public Date getRedate() {
        return redate;
    }

    public void setRedate(Date redate) {
        this.redate = redate;
    }

    public Brooor getBrooor() {
        return brooor;
    }

    public void setBrooor(Brooor brooor) {
        this.brooor = brooor;
    }
}
