package hibernate;

import hibernate.dao.Interfaces.CRUDDao;
import hibernate.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CRUDServiceImpl implements CRUDService {

    private CRUDDao crudDao;

    public void setCrudDao(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    @Transactional
    public List<Subject> searchAll() {
        return crudDao.searchAll();
    }
}
