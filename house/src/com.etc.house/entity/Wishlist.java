package com.etc.house.entity;

public class Wishlist {
    private int wid;
    private House house;
    private Client client;
    public Wishlist(){
//        this.house.getWishlistList().add(this);
//        this.client.getWishlistList().add(this);
    }

    public Wishlist(int wid, House house, Client client) {
        this.wid = wid;
        this.house = house;
        this.client = client;
        this.house.getWishlistList().add(this);
        this.client.getWishlistList().add(this);
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
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
