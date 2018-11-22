package com.company.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ISearch {

    void searchBySubject() throws SQLException;

    void searchByUser() throws SQLException;

    void searchByUserAndDate() throws SQLException;

    void searchByWordMessage() throws SQLException;
}
