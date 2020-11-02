package com.etc.house.entity;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int houseid;
    private String housename;
    private double price;
    private double leasePrice;
    private double hsize;
    private String type;
    private String city;
    private String pic;
    private String htmlAddress;
    private String housestate;
    private double score;
    private String details;
    private List<Lease> leaseList;
    private List<Deal> dealList;
    private List<Wishlist> wishlistList;


    public House(){
        dealList = new ArrayList<>();
        leaseList = new ArrayList<>();
        wishlistList = new ArrayList<>();
    }

    public House(String housename, double price, double hsize, String type, String pic, String htmlAddress) {
        this.housename = housename;
        this.price = price;
        this.hsize = hsize;
        this.type = type;
        this.pic = pic;
        this.htmlAddress = htmlAddress;
    }

    public House(int houseid, String housename, double price, double hsize, String type, String city, String pic, String htmlAddress, String housestate, double score, String details) {
        this.houseid = houseid;
        this.housename = housename;
        this.price = price;
        this.hsize = hsize;
        this.type = type;
        this.city = city;
        this.pic = pic;
        this.htmlAddress = htmlAddress;
        this.housestate = housestate;
        this.score = score;
        this.details = details;
        dealList = new ArrayList<>();
        leaseList = new ArrayList<>();
        wishlistList = new ArrayList<>();
    }

    public double getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(double leasePrice) {
        this.leasePrice = leasePrice;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseid=" + houseid +
                ", housename='" + housename + '\'' +
                ", price=" + price +
                ", leasePrice=" + leasePrice +
                ", hsize=" + hsize +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", pic='" + pic + '\'' +
                ", htmlAddress='" + htmlAddress + '\'' +
                ", housestate='" + housestate + '\'' +
                ", score=" + score +
                ", details='" + details + '\'' +
                ", leaseList=" + leaseList +
                ", dealList=" + dealList +
                ", wishlistList=" + wishlistList +
                '}';
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getHousestate() {
        return housestate;
    }

    public void setHousestate(String housestate) {
        this.housestate = housestate;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getHtmlAddress() {
        return htmlAddress;
    }

    public void setHtmlAddress(String htmlAddress) {
        this.htmlAddress = htmlAddress;
    }

    public int getHouseid() {
        return houseid;
    }

    public void setHouseid(int houseid) {
        this.houseid = houseid;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHsize() {
        return hsize;
    }

    public void setHsize(double hsize) {
        this.hsize = hsize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
