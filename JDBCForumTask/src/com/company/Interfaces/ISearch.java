package com.company.Interfaces;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ISearch {

    void searchBySubject(String s) throws SQLException;

    void searchByUserId(Integer u) throws SQLException;

    void searchByUserIdAndDate(Integer u, String d) throws SQLException;

    void searchByWordMessage(String w) throws SQLException;
}
