package com.etc.jdbc.demo.entity;

public class RoomStudent {
    private int r_sid;
    private Student stu;
    private Room room;
    public RoomStudent(){

    }
    public RoomStudent(Student student , Room room){
        this.room = room;
        this.stu =student;
    }
    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getR_sid() {
        return r_sid;
    }

    public void setR_sid(int r_sid) {
        this.r_sid = r_sid;
    }

}
