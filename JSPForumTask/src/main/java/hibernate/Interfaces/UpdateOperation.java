package hibernate.Interfaces;

import java.sql.Date;

public interface UpdateOperation {

    void updateSubjectById(Integer id, String nickname, String tName, String sName, String message, Date d);
}
