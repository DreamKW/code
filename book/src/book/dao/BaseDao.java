package book.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public interface BaseDao {
    public void openDb() throws ClassNotFoundException, SQLException, IOException, URISyntaxException;
    public void closeResoure() throws SQLException;
    //打开事务
    void openTransaction() throws SQLException, URISyntaxException, IOException, ClassNotFoundException;
    //提交事务
    void commitTransaction() throws SQLException;
    //回滚事务
    void rollbackTransaction() throws SQLException;
}
