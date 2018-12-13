package hibernate;

import hibernate.Exceptions.MyBatchException;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.Factories.InputTypeReader;
import hibernate.FileDataReader.ScvReader;
import hibernate.Implementations.DisplayImpl;
import hibernate.Implementations.SearchBuilderImpl;
import hibernate.Implementations.SearchImpl;
import hibernate.Interfaces.IDisplay;
import hibernate.Interfaces.ISearch;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) throws IOException {

        try {

                    BasicConfigurator.configure();

                    log.info("log4j is work");

                    FactorySearchImpl factorySearch = new FactorySearchImpl();

                    ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf(InputTypeReader.getStrNum()));

                    IDisplay displayBy = new DisplayImpl();

//                    ScvReader scvReader = new ScvReader("DataSubjects.csv");
//
//                    Integer PARAM_CONFIGURATION = 10;
//
//                    log.info("Search by subject");
//
//                    displayBy.display(searchBy.searchBySubject("Capitals"));
//
//                    log.info("Search by subject ignore register");
//
//                    displayBy.display(searchBy.searchBySubjectIgnoreRegister("тема"));
//
//                    log.info("Search by user");
//
//                    displayBy.display(searchBy.searchByUserId(107));
//
//                    log.info("Search by user and date");
//
//                    displayBy.display(searchBy.searchByUserIdAndDate(107, StringAsDate("2017-11-23")));
//
//                    log.info("Search by word in message");
//
//                    displayBy.display(searchBy.searchByWordMessage("%co%"));
//
//                    log.info("Update by user");
//
//                    searchBy.updateMessageByUserId(103);
//
//                    displayBy.display(searchBy.searchAll());
//
//                    log.info("Delete by user");
//
//                    searchBy.deleteMessageByUserId(103);
//
//                    displayBy.display(searchBy.searchAll());
//
//                    log.info("Insert new objects");
//
//                    searchBy.batchInsertSubject(scvReader, PARAM_CONFIGURATION);
            SimpleDateFormat dr = new SimpleDateFormat("MM-dd-yyyy");

                    searchBy.updateSubjectById(101, "a", "b", "c", "d", StringAsDate("03-07-2008") );

                    //searchBy.insertSubject("ewf", "eever", "recwv", "wcsbrbteggtrer", StringAsDate("03-07-2008"));

                    displayBy.display(searchBy.searchAll());


        } catch (MyBatchException e) {
            log.error("Hibernate error : " + e.getMessage(), e);
        } finally {
            if (HibernateSessionFactory.getSessionFactory().openSession().isOpen()) HibernateSessionFactory.shutdown();
        }
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
