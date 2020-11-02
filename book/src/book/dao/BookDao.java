package book.dao;

import book.entity.Book;
import book.entity.Type;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    boolean add(String name, float price, String author, String type) throws SQLException, ClassNotFoundException, IOException, URISyntaxException;

    boolean delete(String name) throws SQLException, ClassNotFoundException, IOException, URISyntaxException;

    boolean update(String name, float price) throws SQLException, ClassNotFoundException, IOException, URISyntaxException;

    Book select(String name) throws SQLException, ClassNotFoundException, IOException, URISyntaxException;

    int addType(Type type) throws SQLException;

    int addBook(Book book) throws SQLException, URISyntaxException, IOException, ClassNotFoundException;

    List<Type> getTypeBook() throws ClassNotFoundException, SQLException, URISyntaxException, IOException;
}
