package hibernate.dao.interfaces;

import hibernate.model.Subject;

import java.util.List;

public interface CRUDDao {

    List<Subject> searchAll();

}
