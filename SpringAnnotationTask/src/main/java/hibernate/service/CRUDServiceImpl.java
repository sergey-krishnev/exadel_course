package hibernate.service;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CRUDServiceImpl implements CRUDService {

    @Autowired
    private CRUDDao crudDao;

    public void setCrudDao(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Subject> searchAll() {
        return crudDao.searchAll();
    }
}
