package Test0817.home;

import test0722.JudgeNo;

import java.util.Random;
import java.util.Scanner;

public class DianMin {
    public static void main(String[] args) {
        String [] names = {"刘心如" ,"宋健","王丽","刘莹","任博恺","王宇","侯艺辉","安志刚","汪东旭",
                "李林","王天利","秦小进","包澳日其楞","李佳伟","杜欣航","吕译辰","侯嘉欣","高源","刘志敏","郝过","王博文","石军刚","邹倩","裴华彬","张天旭","刘昭","魏彦强",
                "张华斌","贺君天","胡雨佳","成功","包宏伟","杨昊","董豪辉","姬越剑","韩全英","闫旭阳","马小强",
                "杨媛媛"};
        System.out.println("======随机点名=======");
        System.out.println("第一名同学：");
        int no = 1;
        while (no == 1){
            Random random = new Random();
            System.out.println(names[random.nextInt(names.length)]);
            System.out.println("是否继续选取下一名学生： 1 继续  0  退出");
            no = JudgeNo.judge();
            while(no != 1 && no !=0){
                System.out.println("请输入正确的选项：");
                no = JudgeNo.judge();

            }
        }



    }
}
