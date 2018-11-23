package com.company;

import com.company.Exceptions.MyJdbcException;
import com.company.Implementations.DisplayImpl;
import com.company.Implementations.SearchImpl;
import com.company.Interfaces.IDisplay;
import com.company.Interfaces.ISearch;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] argv) throws SQLException {

        final Logger log = Logger.getLogger(Main.class);

        try {
            BasicConfigurator.configure();


            ISearch searchBy = new SearchImpl();
            IDisplay displayBy = new DisplayImpl();

            log.info("Search by subject");

            displayBy.display(searchBy.searchBySubject("Capitals"));

            log.info("Search by user");

            displayBy.display(searchBy.searchByUserId(107));

            log.info("Search by user and date");

            displayBy.display(searchBy.searchByUserIdAndDate(107, "2017-11-23"));

            log.info("Search by word in message");

            displayBy.display(searchBy.searchByWordMessage("%co%"));
        } catch (MyJdbcException e) {
            log.error("JDBC error : " + e.getMessage(), e);
        }
    }
}