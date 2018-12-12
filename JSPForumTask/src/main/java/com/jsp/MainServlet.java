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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FactorySearchImpl factorySearch = new FactorySearchImpl();

        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));

        List<Subject> searchAll = searchBy.searchAll();

        req.setAttribute("searchAll", searchAll);

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
