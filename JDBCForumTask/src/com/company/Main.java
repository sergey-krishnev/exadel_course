package com.company;

import com.company.Exceptions.MyJdbcException;
import com.company.FileDataReader.ScvReader;
import com.company.Implementations.DisplayImpl;
import com.company.Implementations.SearchImpl;
import com.company.Interfaces.IDisplay;
import com.company.Interfaces.ISearch;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] argv) throws SQLException, IOException {

        final Logger log = Logger.getLogger(Main.class);

        try {
            BasicConfigurator.configure();


            ISearch searchBy = new SearchImpl();
            IDisplay displayBy = new DisplayImpl();

            ScvReader scvReader = new ScvReader("DataSubjects.csv");

            Integer PARAM_CONFIGURATION = 10;

            log.info("Search by subject");

            displayBy.display(searchBy.searchBySubject("Capitals"));

            log.info("Search by user");

            displayBy.display(searchBy.searchByUserId(107));

            log.info("Search by user and date");

            displayBy.display(searchBy.searchByUserIdAndDate(107, "2017-11-23"));

            log.info("Search by word in message");

            displayBy.display(searchBy.searchByWordMessage("%co%"));

//            log.info("Update by user");
//
//            searchBy.updateMessageByUserId(103);
//
//            displayBy.display(searchBy.searchAll());

//            log.info("Delete by user");
//
//            searchBy.deleteMessageByUserId(103);
//
//            displayBy.display(searchBy.searchAll());

            log.info("Insert new data");

            searchBy.batchInsertSubject(scvReader, PARAM_CONFIGURATION);

            displayBy.display(searchBy.searchAll());

        } catch (MyJdbcException e) {
            log.error("JDBC error : " + e.getMessage(), e);
        }
    }
}