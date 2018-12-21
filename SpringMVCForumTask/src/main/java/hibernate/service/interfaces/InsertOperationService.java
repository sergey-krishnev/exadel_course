package hibernate.service.interfaces;

import java.sql.Date;

public interface InsertOperationService {
    void insertSubject(String username, String topicName, String subjectName, String message,
                       Date date);
}
