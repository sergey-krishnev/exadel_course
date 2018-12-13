package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FactorySearchImpl factorySearch = new FactorySearchImpl();
        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));
        Integer searchId = Integer.valueOf(request.getParameter("subjectId"));
        searchBy.updateSubjectById(searchId,request.getParameter("nickname"),
                request.getParameter("topic"),request.getParameter("subject"),request.getParameter("message"),
                stringAsDate(request.getParameter("date")));
        response.sendRedirect("index.jsp");
    }
    private static java.sql.Date stringAsDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }
}


