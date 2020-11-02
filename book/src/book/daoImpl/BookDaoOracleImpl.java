package book.daoImpl;

import book.dao.BookDao;
import book.entity.Book;
import book.entity.Type;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public class BookDaoOracleImpl extends BaseDaoImpl implements BookDao {
    @Override
    public boolean add(String name, float price, String author, String type) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        return false;
    }

    @Override
    public boolean delete(String name) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        return false;
    }

    @Override
    public boolean update(String name, float price) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        return false;
    }

    @Override
    public Book select(String name) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        return null;
    }

    @Override
    public int addType(Type type) throws SQLException {
        return 0;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        Type type = new Type("a");
        Book book = new Book(2,type,"a",33.0);
        new BookDaoOracleImpl().addBook(book);
    }
    @Override
    public int addBook(Book book) throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        openDb();
        String sql = "insert into book (b_id,b_name,price)values('"+book.getB_id()+"','"+book.getB_name()+"','"+book.getPrice()+"')";
        st = con.createStatement();
        int no = st.executeUpdate(sql);
        closeResoure();
        return no;
    }

    @Override
    public List<Type> getTypeBook() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        return null;
    }
}
