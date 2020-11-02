package com.etc.house.entity;

import java.util.Date;

public class Deal {
    private int deaid;
    private double sum;
    private Date dealdate;
    private int state;
    private House house;
    private Client client;
    public Deal(){
        this.house.getDealList().add(this);
        this.client.getDealList().add(this);
    }

    public Deal(int deaid, double sum, Date dealdate, int state, House house, Client client) {
        this.deaid = deaid;
        this.sum = sum;
        this.dealdate = dealdate;
        this.state = state;
        this.house = house;
        this.client = client;
        this.house.getDealList().add(this);
        this.client.getDealList().add(this);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDeaid() {
        return deaid;
    }

    public void setDeaid(int deaid) {
        this.deaid = deaid;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDealdate() {
        return dealdate;
    }

    public void setDealdate(Date dealdate) {
        this.dealdate = dealdate;
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
}
