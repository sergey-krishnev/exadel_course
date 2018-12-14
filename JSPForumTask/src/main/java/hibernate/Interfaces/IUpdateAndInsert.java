package hibernate.Interfaces;

import hibernate.Topic;
import hibernate.Users;

public interface IUpdateAndInsert {
    void updateSubjectById(Integer id, String nickname, String tName, String sName, String message, java.sql.Date d);

    void insertSubject(String nickname, String tName, String sName, String message, java.sql.Date d);

    Users searchByUserName(String s);

    Topic searchByTopicName(String s);
}
