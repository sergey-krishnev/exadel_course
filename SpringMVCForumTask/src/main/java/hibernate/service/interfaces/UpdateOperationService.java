package hibernate.service.interfaces;

import java.sql.Date;

public interface UpdateOperationService {
    void updateSubjectById(Integer id, String username, String topicName, String subjectName,
                           String message, Date date);
}
