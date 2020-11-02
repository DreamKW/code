package com.etc.jdbc.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int r_id;
    private String name;
    private List<RoomStudent> roomStudents;
//room（一）与room_student（多） 之间是一对多的关系
    public Room (){
        roomStudents = new ArrayList<>();
    }

    public Room(String name){
        this.name = name;
        roomStudents = new ArrayList<>();
    }
    public List<RoomStudent> getRoomStudents() {
        return roomStudents;
    }

    public void setRoomStudents(List<RoomStudent> roomStudents) {
        this.roomStudents = roomStudents;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
