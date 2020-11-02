package studentsystem.serviceImpl;

import studentsystem.dao.DataDao;
import studentsystem.service.DataService;

public class DataServiceImpl  implements DataService {
    public int getNo() throws Exception {
        DataDao dao = (DataDao) new ReflectSvImpl();
        return dao .getNo();
    }

}
