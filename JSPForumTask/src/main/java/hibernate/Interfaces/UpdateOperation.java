package hibernate.Interfaces;

import java.sql.Date;

public interface UpdateOperation {

    void updateSubjectById(Integer id, String username, String topicName, String subjectName, String message, Date date);
}
