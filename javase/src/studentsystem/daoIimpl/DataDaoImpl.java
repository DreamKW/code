package studentsystem.daoIimpl;

import studentsystem.dao.DataDao;

import static studentsystem.util.JudgeNo.judge;

public class DataDaoImpl implements DataDao {
    public int getNo() {
        return judge();
    }
}
