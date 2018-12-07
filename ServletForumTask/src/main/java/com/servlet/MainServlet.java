package com.servlet;

import com.sun.xml.internal.bind.v2.model.core.ID;
import hibernate.Implementations.AllSubjectDisplayImpl;
import hibernate.Implementations.DisplayImpl;
import hibernate.Implementations.SearchImpl;
import hibernate.Interfaces.IDisplay;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;
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
import java.util.List;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    final static Logger log = Logger.getLogger(MainServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IDisplay d = new AllSubjectDisplayImpl();

        execute(request,response,d.displayAll(),"searchByAll");
//        try {

//            BasicConfigurator.configure();


//            FactorySearchImpl factorySearch = new FactorySearchImpl();
//
//            InputTypeReader.getStrNum()
//
//            factorySearch.getSearchImpl(Integer.valueOf("0"))

//            ISearch searchBy = new SearchImpl();
//
//            IDisplay displayBy = new DisplayImpl();

//            ScvReader scvReader = new ScvReader("DataSubjects.csv");

            Integer PARAM_CONFIGURATION = 10;

//            out.println("Search by subject");

//            out.println(displayBy.displayToListString(searchBy.searchBySubject("Capitals")));
//
//            out.println("Search by subject ignore register");
//
//            out.println(displayBy.displayToListString(searchBy.searchBySubjectIgnoreRegister("тема")));

//            out.println("Search by user");
//
//            out.println(displayBy.displayToListString(searchBy.searchByUserId(107)));
//
//            out.println("Search by user and date");
//
//            out.println(displayBy.displayToListString(searchBy.searchByUserIdAndDate(107, StringAsDate("2017-11-23"))));
//
//            out.println("Search by word in message");
//
//            out.println(displayBy.displayToListString(searchBy.searchByWordMessage("%co%")));
//
//            out.println("Update by user");
//
//            searchBy.updateMessageByUserId(103);
//
//            out.println(displayBy.displayToListString(searchBy.searchAll()));
//
//            out.println("Delete by user");
//
//            searchBy.deleteMessageByUserId(103);
//
//            out.println(displayBy.displayToListString(searchBy.searchAll()));
//
//            out.println("Insert new objects");
//
//            searchBy.batchInsertSubject(scvReader, PARAM_CONFIGURATION);
//
//            out.println(displayBy.displayToListString(searchBy.searchAll()));
//
//
//        } catch (MyBatchException e) {
//            log.error("Hibernate error : " + e.getMessage(), e);
//        } finally {
//            if (HibernateSessionFactory.getSessionFactory().openSession().isOpen()) HibernateSessionFactory.shutdown();
//        }


    }

    private void execute(HttpServletRequest request, HttpServletResponse response, List<String> theSubjectList,
                         String attribute ) throws ServletException, IOException {

            request.setAttribute(attribute, theSubjectList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
