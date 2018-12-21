package hibernate.dao.interfaces;

import java.sql.Date;

public interface InsertOperation {

    void insertSubject(String username, String topicName, String subjectName, String message,
                       Date date);

}
