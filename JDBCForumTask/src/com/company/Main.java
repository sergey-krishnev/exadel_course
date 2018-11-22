package com.company;

import com.company.Implementations.SearchImpl;
import com.company.Interfaces.ISearch;

import java.sql.*;

public class Main {

    public static void main(String[] argv) throws SQLException {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }
        System.out.println("PostgreSQL JDBC Driver Registered!");

        ISearch search_by = new SearchImpl();

        System.out.println("Search by Subject");

        search_by.searchBySubject();

        System.out.println("Search by user");

        search_by.searchByUser();

        System.out.println("Search by user and date");

        search_by.searchByUserAndDate();

        System.out.println("Search by word in message");

        search_by.searchByWordMessage();
    }

}