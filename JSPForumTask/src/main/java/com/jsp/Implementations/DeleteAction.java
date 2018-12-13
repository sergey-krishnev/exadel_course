package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FactorySearchImpl factorySearch = new FactorySearchImpl();

        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));
        String subjectId = request.getParameter("subjectId");
        searchBy.deleteSubjectById(Integer.valueOf(subjectId));
        List<Subject> searchAll = searchBy.searchAll();
        request.setAttribute("searchAll", searchAll);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
