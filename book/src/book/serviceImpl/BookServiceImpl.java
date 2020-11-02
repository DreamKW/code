package book.serviceImpl;

import book.dao.BookDao;
import book.daoImpl.BaseDaoImpl;
import book.daoImpl.BookDaoImpl;
import book.entity.Book;
import book.entity.Type;
import book.service.BookService;
import book.util.Log;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao dao = new BookDaoImpl();
    /**
     * 获取图书类型信息
     */
    public List<Type> getTypeBook() throws SQLException{
        List<Type> types = null;
        try{
            types = dao.getTypeBook();
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());

        }finally {
            ((BookDaoImpl)dao).closeResoure();
        }
        return types;
    }

    /**
     * 添加书名类型信息
     * @param type
     * @return
     * @throws SQLException
     */

    public int addTypeBook(Type type) throws SQLException {
        int no = 0;
        try{
//            打开事务
//            添加类型信息
            ((BookDaoImpl)dao).openTransaction();
            int tid = dao.addType(type);
            type.setT_id(tid);
//            添加图书信息
            List<Book> books = type.getBookList();

            for (Book book :
                books  ) {
                no = dao.addBook(book);
            }
//            提交事务
            ((BookDaoImpl)dao).commitTransaction();

        }catch (Exception e){
//            回滚事务
            ((BookDaoImpl)dao).rollbackTransaction();
//            添加日志
            Log.mylog.debug("添加图书信息："+e.getMessage());
            e.printStackTrace();
        }finally {
            //            关闭资源
            ((BookDaoImpl)dao).closeResoure();
        }
        return no;
    }

    @Override
    public boolean add(String name, float price, String author, String type) throws SQLException {
        boolean flag = false;
        try {
           flag =  dao.add(name,price,author,type);
        } catch (SQLException | ClassNotFoundException | IOException | URISyntaxException e) {
            Log.mylog.debug(e.getMessage());
            e.printStackTrace();
        }  finally {
            ((BookDaoImpl)dao).closeResoure();
        }
        return flag;
    }

    @Override
    public boolean delete(String name) throws SQLException {
        boolean flag = false;
        try {
            flag =  dao.delete(name);
        } catch (SQLException | IOException | URISyntaxException | ClassNotFoundException e) {
            Log.mylog.debug(e.getMessage());

            e.printStackTrace();
        } finally {
            ((BookDaoImpl)dao).closeResoure();
        }
        return flag;
    }

    @Override
    public boolean update(String name, float price) throws SQLException {
        boolean flag =false;
        try {
           flag  =dao.update(name,price);
        } catch (SQLException | IOException | URISyntaxException | ClassNotFoundException e) {
            Log.mylog.debug(e.getMessage());

            e.printStackTrace();
        }finally {
            ((BookDaoImpl)dao).closeResoure();
        }
        return flag;

    }

    @Override
    public Book select(String name) throws SQLException, ClassNotFoundException {
        Book book  = null;
        try {
            book =  dao.select(name);

        }catch (Exception e){
            Log.mylog.debug(e.getMessage());

            e.printStackTrace();
        }finally {
            //关闭资源
            ((BookDaoImpl)dao).closeResoure();
        }
        return book;



    }
}
