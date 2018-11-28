package jpa.Interfaces;

import jpa.Subject;

import java.util.List;

public interface ISearch {
    List<Subject> searchBySubject(String s);

    List<Subject> searchByUserId(Integer u);

    List<Subject> searchByUserIdAndDate(Integer u, java.sql.Date d);

    List<Subject> searchByWordMessage(String w);

    List<Subject> searchAll();

    void updateMessageByUserId(Integer u);

    void deleteMessageByUserId(Integer u);

}
