package book.ui;

import book.util.JudgeNo;

import java.sql.SQLException;
import java.util.Scanner;

public class BookStore {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
boolean flag = true;
      while (flag){
          System.out.println("=======图书管理系统======");
          System.out.println("   1.上架");
          System.out.println("   2.下架");
          System.out.println("   3.查询");
          System.out.println("   4.修改");
          System.out.println("   5.退出");
          System.out.println("=========================");
          int  input = JudgeNo.judge();
          switch (input){
              case 1:{
                  new BookUi().add();
                  break;
              }
              case 2:{
                  new BookUi().delete();
                  break;
              }
              case 3:{
                  new BookUi().select();
                  break;
              }
              case 4:{
                  new BookUi().update();
                  break;
              }
              case 5:{
                  System.out.println("退出成功");
                  flag = false;
                  break;

              }
              default:{
                  System.out.println("没有该功能！！！");
              }
          }



      }


    }
}
