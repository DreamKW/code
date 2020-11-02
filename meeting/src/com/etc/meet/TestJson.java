package com.etc.meet;

import com.etc.meet.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestJson {
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();
//        对象转换为json
        user.setState("1");
        user1.setState("2");
        JSONObject userobject1 = JSONObject.fromObject(user);
        System.out.println(userobject1.toString());
//          集合转换为json
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        JSONArray array = JSONArray.fromObject(userList);
        System.out.println(array);


    }
}



