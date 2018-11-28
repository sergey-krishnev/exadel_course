package jpa;

import jpa.Implementations.DisplayImpl;
import jpa.Implementations.SearchImpl;
import jpa.Interfaces.IDisplay;
import jpa.Interfaces.ISearch;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import jpa.Subject;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    private static EntityManager em;

    public static void main(String[] args) {

        BasicConfigurator.configure();

        logger.info("log4j is work");

        ISearch searchBy = new SearchImpl();
        IDisplay displayBy = new DisplayImpl();
        displayBy.display(searchBy.searchBySubject("Capitals"));

    }

}
