package hibernate.dao.Interfaces;

import hibernate.model.Subject;

import java.util.List;

public interface CRUDDao {

    List<Subject> searchAll();

}
