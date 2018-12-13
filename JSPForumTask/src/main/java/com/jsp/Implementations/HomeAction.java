package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomeAction implements Action {
    private static String LIST_RECORDS = "index.jsp";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FactorySearchImpl factorySearch = new FactorySearchImpl();

        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));

        List<Subject> searchAll = searchBy.searchAll();
        request.setAttribute("searchAll", searchAll);
        request.getRequestDispatcher(LIST_RECORDS).forward(request, response);
        return "home";
    }
}
