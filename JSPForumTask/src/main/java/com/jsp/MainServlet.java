package com.jsp;

import hibernate.Factories.FactorySearchImpl;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {

    private static String INSERT_OR_EDIT = "add.jsp";
    private static String LIST_RECORDS = "index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FactorySearchImpl factorySearch = new FactorySearchImpl();

        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));

        List<Subject> searchAll = searchBy.searchAll();
        req.setAttribute("searchAll", searchAll);
        req.getRequestDispatcher(LIST_RECORDS).forward(req, resp);

//        String forward = "";
//
//        String action = req.getParameter("action");

//        if (action.equalsIgnoreCase("delete")) {
//            String subjectId = req.getParameter("subjectId");
//            searchBy.deleteSubjectById(Integer.valueOf(subjectId));
//            forward = LIST_RECORDS;
//            List<Subject> searchAll = searchBy.searchAll();
//            req.setAttribute("searchAll", searchAll);
//        } else if (action.equalsIgnoreCase("edit")){
//            forward = INSERT_OR_EDIT;
//            String subjectId = req.getParameter("subjectId");
//            Subject subject = searchBy.searchBySubjectId(Integer.valueOf(subjectId));
//            req.setAttribute("subject", subject);
//        } else {
//            forward = INSERT_OR_EDIT;
//        }
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
