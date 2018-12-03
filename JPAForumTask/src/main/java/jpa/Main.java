package jpa;

import jpa.Exceptions.MyBatchException;
import jpa.Factories.FactorySearchImpl;
import jpa.Factories.InputTypeReader;
import jpa.FileDataReader.ScvReader;
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

        BasicConfigurator.configure();

        log.info("log4j is work");

        FactorySearchImpl factorySearch = new FactorySearchImpl();

        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf(InputTypeReader.getStrNum()));

        IDisplay displayBy = new DisplayImpl();

        ScvReader scvReader = new ScvReader("DataSubjects.csv");

        Integer PARAM_CONFIGURATION = 10;

        log.info("Search by subject");

        displayBy.display(searchBy.searchBySubject("Capitals"));

        log.info("Search by user");

        displayBy.display(searchBy.searchByUserId(107));

        log.info("Search by user and date");

        displayBy.display(searchBy.searchByUserIdAndDate(107, StringAsDate("2017-11-23") ));

        log.info("Search by word in message");

        displayBy.display(searchBy.searchByWordMessage("%co%"));

        log.info("Update by user");

        searchBy.updateMessageByUserId(103);

        displayBy.display(searchBy.searchAll());

        log.info("Delete by user");

        searchBy.deleteMessageByUserId(103);

        displayBy.display(searchBy.searchAll());

        log.info("Insert new objects");

        try {
            searchBy.batchInsertSubject(scvReader, PARAM_CONFIGURATION);
        } catch (MyBatchException e) {
            log.error(e);
        }

        displayBy.display(searchBy.searchAll());

    }

    private static java.sql.Date StringAsDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  new java.sql.Date(date.getTime());
    }

}
