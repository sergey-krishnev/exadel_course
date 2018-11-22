package com.company;

import com.company.Implementations.SearchImpl;
import com.company.Interfaces.ISearch;
import org.apache.log4j.BasicConfigurator;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] argv) throws SQLException, ParseException {

        BasicConfigurator.configure();

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

        search_by.searchBySubject("Capitals");

        System.out.println("Search by user");

        search_by.searchByUserId(107);

        System.out.println("Search by user and date");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        search_by.searchByUserIdAndDate(107,"2017-11-23");

        System.out.println("Search by word in message");

        search_by.searchByWordMessage("%co%");
    }
}