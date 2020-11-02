package com.etc.house.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lease {
    private int leaseid;
    private double sum;
    private Date enddate;
    private Date begindate;
    private Date leasedate;
    private int state;
    private House house;
    private Client client;
    private List<Access> accessList;
    public Lease(){
        accessList = new ArrayList<>();

        this.house.getLeaseList().add(this);
        this.client.getLeaseList().add(this);
    }

    public Lease(int leaseid, double sum, Date enddate, Date begindate, Date leasedate, House house, int state, Client client) {
        this.leaseid = leaseid;
        this.sum = sum;
        this.enddate = enddate;
        this.begindate = begindate;
        this.leasedate = leasedate;
        this.house = house;
        this.state = state;
        this.client = client;
        this.house.getLeaseList().add(this);
        this.client.getLeaseList().add(this);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLeaseid() {
        return leaseid;
    }

    public void setLeaseid(int leaseid) {
        this.leaseid = leaseid;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getLeasedate() {
        return leasedate;
    }

    public void setLeasedate(Date leasedate) {
        this.leasedate = leasedate;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Access> getAccessList() {
        return accessList;
    }

    public void setAccessList(List<Access> accessList) {
        this.accessList = accessList;
    }
}
