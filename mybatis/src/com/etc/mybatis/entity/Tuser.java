package com.etc.mybatis.entity;


public class Tuser {
   private int  userid ;
   private String uname  ;
   private String pwd;
   private int age;
   private double money;
   private String role;


   public Tuser(){};

   public Tuser(int userid, String uname, String pwd, int age, double money) {
      this.pwd = pwd;
      this.userid = userid;
      this.uname = uname;
      this.age = age;
      this.money = money;

   }

   @Override
   public String toString() {
      return "Tuser{" +
              "userid=" + userid +
              ", uname='" + uname + '\'' +
              ", pwd='" + pwd + '\'' +
              ", age=" + age +
              ", money=" + money +
              ", role='" + role + '\'' +
              '}';
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public double getMoney() {
      return money;
   }

   public void setMoney(double money) {
      this.money = money;
   }

   public String getPwd() {
      return pwd;
   }

   public void setPwd(String pwd) {
      this.pwd = pwd;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public int getUserid() {
      return userid;
   }

   public void setUserid(int userid) {
      this.userid = userid;
   }

   public String getUname() {
      return uname;
   }

   public void setUname(String uname) {
      this.uname = uname;
   }}

