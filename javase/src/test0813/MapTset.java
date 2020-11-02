package test0813;

import java.util.*;

public class MapTset {
    public static void main(String[] args) {

        HashMap <String, String> stringStringHashMap  = new HashMap<>(3);
        System.out.println(stringStringHashMap.size());
        System.out.println("===============");

        HashMap<String,Integer> map = new HashMap<>();
        map.put("one",1);
        System.out.println(map.size());
        map.put("one",2);
        System.out.println(map.size());
        map.put("two",2);
        map.put("three",3);
        map.put("aa",4);
        map.put("ab",4);
        map.put("a1",4);
        map.put("a2",4);
        map.put("b",3);
        map.put("c",9);
        map.remove("s");
        System.out.println(map.size());
        System.out.println(map.get("one"));//结果为2 修改key 为one value的值为2
        //获取到所有的key值
        Set<String> set = map.keySet();
        Iterator<String> it =  set.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key  + " "+map.get(key) + "       ");
        }
    }
}
