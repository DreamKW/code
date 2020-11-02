package book.service;

import book.entity.Book;
import book.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface BookService {
     List<Type> getTypeBook() throws SQLException;
     int addTypeBook(Type type) throws SQLException;
    boolean add(String name, float price, String author, String type) throws SQLException;

    boolean delete(String name) throws SQLException;

    boolean update(String name, float price) throws SQLException;

    Book select(String name) throws SQLException, ClassNotFoundException;
}
