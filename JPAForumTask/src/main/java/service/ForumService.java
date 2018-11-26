package service;

import entity.Subject;

import java.util.List;

public interface ForumService {
    List<Subject> searchBySubject(String s);

    List<Subject> searchByUserId(Integer u);

    List<Subject> searchByUserIdAndDate(Integer u, String d);

    List<Subject> searchByWordMessage(String w);

    List<Subject> searchAll();

    void updateMessageByUserId(Integer u);

    void deleteMessageByUserId(Integer u);

    void updateAndDeleteMessageByUserId(String u, Integer w);
}
