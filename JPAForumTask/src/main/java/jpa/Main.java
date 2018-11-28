package jpa;

import jpa.Factories.FactorySearchImpl;
import jpa.Implementations.DisplayImpl;
import jpa.Implementations.SearchBuilderImpl;
import jpa.Implementations.SearchImpl;
import jpa.Interfaces.IDisplay;
import jpa.Interfaces.ISearch;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import jpa.Subject;

public class Main {

    final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse("2017-11-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());


        BasicConfigurator.configure();

        log.info("log4j is work");

        String strNum = null;

        BufferedReader bis = null;

        FactorySearchImpl factorySearch = new FactorySearchImpl();
        try {
        bis = new BufferedReader(new InputStreamReader(System.in));

            strNum = bis.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) bis.close();
        }

        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf(strNum));

        IDisplay displayBy = new DisplayImpl();


        log.info("Search by subject");

        displayBy.display(searchBy.searchBySubject("Capitals"));

        log.info("Search by user");

        displayBy.display(searchBy.searchByUserId(107));

        log.info("Search by user and date");

        displayBy.display(searchBy.searchByUserIdAndDate(107, sqlDate));

        log.info("Search by word in message");

        displayBy.display(searchBy.searchByWordMessage("%co%"));

        log.info("Update by user");

        searchBy.updateMessageByUserId(103);

        displayBy.display(searchBy.searchAll());

        log.info("Delete by user");

        searchBy.deleteMessageByUserId(103);

        displayBy.display(searchBy.searchAll());

    }

}
