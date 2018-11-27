package jpa.Interfaces;

import jpa.Subject;

import java.util.List;

public interface ISearch {
    List searchBySubject(String s);

    List searchByUserId(Integer u);

    List searchByUserIdAndDate(Integer u, String d);

    List searchByWordMessage(String w);

    List searchAll();

}
