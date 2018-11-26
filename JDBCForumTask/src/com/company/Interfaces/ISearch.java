package com.company.Interfaces;

import com.company.ForumParts.Results;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ISearch {

    List<Results> searchBySubject(String s) throws SQLException;

    List<Results> searchByUserId(Integer u) throws SQLException;

    List<Results> searchByUserIdAndDate(Integer u, String d) throws SQLException;

    List<Results> searchByWordMessage(String w) throws SQLException;

    List<Results> updateMessageByUserId(Integer u) throws SQLException;

    List<Results> deleteMessageByUserId(Integer u) throws SQLException;
}
