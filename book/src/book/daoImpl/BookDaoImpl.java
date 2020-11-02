package book.daoImpl;

import book.dao.BookDao;
import book.entity.Book;
import book.entity.Type;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDaoImpl implements BookDao {
    boolean falg = false;

    @Override
    public boolean add(String name, float price, String author, String type) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        openDb();
        String sql = "INSERT into book (name,price,author,type) VALUES(?,?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setFloat(2,price);
        ps.setString(3,author);
        ps.setString(4,type);
        int a  = ps.executeUpdate();
        if (a == 0){
            falg = false;
        }else {
            falg = true;
        }
        return falg;
    }

    @Override
    public boolean delete(String name) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        openDb();
        String sql = "delete from book where name = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1,name);
        int a  = ps.executeUpdate();
        if (a == 0){
            falg = false;
        }else {
            falg = true;
        }

        return falg;
    }

    @Override
    public boolean update(String name, float price) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        openDb();
        String sql = "update book set price = ? where name = ?";
        ps = con.prepareStatement(sql);
        ps.setFloat(1,price);
        ps.setString(2,name);
        int a  = ps.executeUpdate();

        if (a == 0){
            falg = false;
        }else {
            falg = true;
        }

        return falg;
    }

    @Override
    public Book select(String name) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {

        //打开数据库
        openDb();
        //用问号表示占位符
        String sql = "select * from book where name = ? ";
        //预编译
        ps = con.prepareStatement(sql);
        //当有占位符时，要对预编译的对象进行占位符处理
        ps.setString(1,name);
        //返回结果集
        rs = ps.executeQuery();
        Book book = null;
        while (rs.next()){
            book = new Book();
//            book.setName(rs.getString("name"));
//            book.setPrice(rs.getFloat("price"));
//            book.setAuthor(rs.getString("author"));
//            book.setType(rs.getString("type"));
        }
        return book;
    }

    @Override
    public int addType(Type type) throws SQLException {
//      先判断数据库中是否有本次添加的数据类型
//        String sql ="select t_id from type where t_name = ?";
//        ps = con.prepareStatement(sql);
//        ps.setString(1,type.getT_name());
//        rs = ps.executeQuery();

//        因为开启了事务，打开数据库在service 层中，此处不需要打开数据库

        String sql ="select t_id from type where t_name = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1,type.getT_name());
        rs = ps.executeQuery();
        boolean flag =rs.next();
        if(!flag){
            sql = "insert into type (t_name) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,type.getT_name());
            ps.executeUpdate();
        }
        int tid = 0;
        sql = "select * from type";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            tid = rs.getInt(1);
            System.out.println(tid + "----");
        }
        return tid;
    }


    @Override
    public int addBook(Book book) throws SQLException {
        String sql = "insert into book (t_id,b_name,price)values(?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1,book.getType().getT_id());
        ps.setString(2,book.getB_name());
        ps.setDouble(3,book.getPrice());
        return ps.executeUpdate();

    }

    @Override
    public List<Type> getTypeBook() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDb();
        String sql ="SELECT\n" +
                "\t*\n" +
                "FROM\n" +
                "\ttype\n" +
                "\tINNER JOIN\n" +
                "\tbook\n" +
                "\tON \n" +
                "\t\ttype.t_id = book.t_id";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        List<Type> types = new ArrayList<>();
        while (rs.next()){
            Type type = new Type();
            type.setT_id(rs.getInt(1));
            type.setT_name(rs.getString(2));
            Book book = new Book(type,rs.getString(5),rs.getDouble(6));
            types.add(type);
        }
        return types;
    }
}
