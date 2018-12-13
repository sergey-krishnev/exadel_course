package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class AddAction implements Action {
    SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            FactorySearchImpl factorySearch = new FactorySearchImpl();
            ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));
            searchBy.insertSubject(request.getParameter("nickname"),
                    request.getParameter("topic"),request.getParameter("subject"),request.getParameter("message"),
                    (Date) df.parse(request.getParameter("dateSending")));
            response.sendRedirect("index.jsp");
            return "success";
        }catch(RuntimeException e) {
            request.setAttribute("errorMessage", e.getMessage());// to show exception msg in jsp.
            //log exception to console or file here..
            return "failure";
        }
    }
}
