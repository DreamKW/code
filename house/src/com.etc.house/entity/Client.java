package com.etc.house.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int clientid;
    private String clientname;
    private String clientpwd;
    private String clienttell;
    private String type;
    private List<Lease> leaseList;
    private List<Deal> dealList;
    private List<Wishlist> wishlistList;
    public Client(){
        dealList = new ArrayList<>();
        leaseList = new ArrayList<>();
        wishlistList = new ArrayList<>();
    }

    public Client(int clientid, String clientname, String clientpwd, String clienttell) {
        this.clientid = clientid;
        this.clientname = clientname;
        this.clientpwd = clientpwd;
        this.clienttell = clienttell;

    }

    public Client(int clientid, String clientname, String clientpwd, String clienttell, String type) {
        this.clientid = clientid;
        this.clientname = clientname;
        this.clientpwd = clientpwd;
        this.clienttell = clienttell;
        this.type = type;
        dealList = new ArrayList<>();
        leaseList = new ArrayList<>();
        wishlistList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientid=" + clientid +
                ", clientname='" + clientname + '\'' +
                ", clientpwd='" + clientpwd + '\'' +
                ", clienttell='" + clienttell + '\'' +
                ", type='" + type + '\'' +
                ", leaseList=" + leaseList +
                ", dealList=" + dealList +
                ", wishlistList=" + wishlistList +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClientpwd() {
        return clientpwd;
    }

    public void setClientpwd(String clientpwd) {
        this.clientpwd = clientpwd;
    }

    public String getClienttell() {
        return clienttell;
    }

    public void setClienttell(String clienttell) {
        this.clienttell = clienttell;
    }

    public List<Lease> getLeaseList() {
        return leaseList;
    }

    public void setLeaseList(List<Lease> leaseList) {
        this.leaseList = leaseList;
    }

    public List<Deal> getDealList() {
        return dealList;
    }

    public void setDealList(List<Deal> dealList) {
        this.dealList = dealList;
    }

    public List<Wishlist> getWishlistList() {
        return wishlistList;
    }

    public void setWishlistList(List<Wishlist> wishlistList) {
        this.wishlistList = wishlistList;
    }
}
