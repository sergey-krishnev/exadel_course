package service.jpa;

import entity.Subject;
import service.ForumService;

import java.util.List;

public class ForumServiceImpl implements ForumService {
    public List<Subject> searchBySubject(String s) {
        return null;
    }

    public List<Subject> searchByUserId(Integer u) {
        return null;
    }

    public List<Subject> searchByUserIdAndDate(Integer u, String d) {
        return null;
    }

    public List<Subject> searchByWordMessage(String w) {
        return null;
    }

    public List<Subject> searchAll() {
        return null;
    }

    public void updateMessageByUserId(Integer u) {

    }

    public void deleteMessageByUserId(Integer u) {

    }

    public void updateAndDeleteMessageByUserId(String u, Integer w) {

    }
}
