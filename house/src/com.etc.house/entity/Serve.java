package com.etc.house.entity;

import java.util.ArrayList;
import java.util.List;

public class Serve {
    private int serveid;
    private String servename;
    private String servepwd;
    private String servetell;
    public Serve(){

    }

    public Serve(int serveid, String servename, String servepwd, String servetell) {
        this.serveid = serveid;
        this.servename = servename;
        this.servepwd = servepwd;
        this.servetell = servetell;

    }

    @Override
    public String toString() {
        return "Serve{" +
                "serveid=" + serveid +
                ", servename='" + servename + '\'' +
                ", servepwd='" + servepwd + '\'' +
                ", servetell='" + servetell + '\'' +

                '}';
    }

    public int getServeid() {
        return serveid;
    }

    public void setServeid(int serveid) {
        this.serveid = serveid;
    }

    public String getServename() {
        return servename;
    }

    public void setServename(String servename) {
        this.servename = servename;
    }

    public String getServepwd() {
        return servepwd;
    }

    public void setServepwd(String servepwd) {
        this.servepwd = servepwd;
    }

    public String getServetell() {
        return servetell;
    }

    public void setServetell(String servetell) {
        this.servetell = servetell;
    }

}
