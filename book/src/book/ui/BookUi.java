package book.ui;

import book.entity.Book;
import book.entity.Type;
import book.service.BookService;
import book.serviceImpl.BookServiceImpl;
import book.util.JudgeNo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookUi {

    Scanner input = new Scanner(System.in);
    BookService bookService = new BookServiceImpl();
    public void add() throws SQLException {
        Type type = new Type("p");
        Book book1 = new Book(type,"xA1111",22.2);
        Book book2 = new Book(type,"xB1111",22.2);
        int no = ((BookServiceImpl)bookService).addTypeBook(type);
        if (no > 0) System.out.println("添加成功！");
        else System.out.println("添加失败！");


//        System.out.println("书名");
//        String name = input.next();
//        System.out.println("价格");
//        float price = JudgeNo.judge();
//        System.out.println("作者");
//        String author = input.next();
//        System.out.println("类型");
//        String type = input.next();
//        Book book = new Book(name,price,author,type);
//        bookService.add(name,price,author,type);
    }

    public void delete() throws SQLException {
        System.out.println("请输入你要删除的书的名字：");
        String name = input.next();
        bookService.delete(name);
    }

    public void update() throws SQLException {
        System.out.println("请输入你要修改书的名字：");
        String name = input.next();
        System.out.println("请输入新的价格：");
        float price = JudgeNo.judge();
        bookService.update(name,price);
    }

    public void select() throws SQLException, ClassNotFoundException {
//        System.out.println("请输入你要查询的书名：");
//        String name =input.next();
//        Book book = bookService.select(name);
//        System.out.println(book);
        List<Type> types = bookService.getTypeBook();
        for (Type t :
                types) {
            System.out.println("类型："+t.getT_name());
            for (Book b :t.getBookList()){
                System.out.println("书名："+b.getB_name());
            }
        }


    }


}
