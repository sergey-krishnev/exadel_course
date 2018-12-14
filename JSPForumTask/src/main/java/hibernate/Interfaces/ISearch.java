package hibernate.Interfaces;

import hibernate.FileDataReader.ScvReader;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;

import java.util.List;

public interface ISearch extends IUpdateAndInsert {
    List<Subject> searchBySubject(String s);

    Subject searchBySubjectId(Integer u);

    List<Subject> searchByUserId(Integer u);

    List<Subject> searchByUserIdAndDate(Integer u, java.sql.Date d);

    List<Subject> searchByWordMessage(String w);

    List<Subject> searchAll();

    List<Users> searchAllUsers();

    List<Topic> searchAllTopic();

    List<Subject> searchBySubjectIgnoreRegister (String s);

    void updateMessageByUserId(Integer u);

    void deleteSubjectById(Integer u);

    void batchInsertSubject(ScvReader scvReader, Integer numConf);
}
