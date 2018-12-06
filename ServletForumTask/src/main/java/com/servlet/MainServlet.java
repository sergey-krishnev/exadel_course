package com.servlet;

import hibernate.Exceptions.MyBatchException;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.Factories.InputTypeReader;
import hibernate.FileDataReader.ScvReader;
import hibernate.Implementations.DisplayImpl;
import hibernate.Interfaces.IDisplay;
import hibernate.Interfaces.ISearch;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    final static Logger log = Logger.getLogger(MainServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Hello Word!");

        try {

            BasicConfigurator.configure();

            out.println("log4j is work");

            FactorySearchImpl factorySearch = new FactorySearchImpl();

            //InputTypeReader.getStrNum()

            ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));

            IDisplay displayBy = new DisplayImpl();

            ScvReader scvReader = new ScvReader("DataSubjects.csv");

            Integer PARAM_CONFIGURATION = 10;

            out.println("Search by subject");

            out.println(displayBy.displayToListString(searchBy.searchBySubject("Capitals")));

            out.println("Search by subject ignore register");

            out.println(displayBy.displayToListString(searchBy.searchBySubjectIgnoreRegister("тема")));

            out.println("Search by user");

            out.println(displayBy.displayToListString(searchBy.searchByUserId(107)));

            out.println("Search by user and date");

            out.println(displayBy.displayToListString(searchBy.searchByUserIdAndDate(107, StringAsDate("2017-11-23"))));

            out.println("Search by word in message");

            out.println(displayBy.displayToListString(searchBy.searchByWordMessage("%co%")));

            out.println("Update by user");

            searchBy.updateMessageByUserId(103);

            out.println(displayBy.displayToListString(searchBy.searchAll()));

            out.println("Delete by user");

            searchBy.deleteMessageByUserId(103);

            out.println(displayBy.displayToListString(searchBy.searchAll()));

            out.println("Insert new objects");

            searchBy.batchInsertSubject(scvReader, PARAM_CONFIGURATION);

            out.println(displayBy.displayToListString(searchBy.searchAll()));


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
