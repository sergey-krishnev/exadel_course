package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditFormAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FactorySearchImpl factorySearch = new FactorySearchImpl();

        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));
        String subjectId = request.getParameter("subjectId");
        List<Users> users = searchBy.searchAllUsers();
        request.setAttribute("users", users);
        List<Topic> topics = searchBy.searchAllTopic();
        request.setAttribute("topics", topics);
        Subject subject = searchBy.searchBySubjectId(Integer.valueOf(subjectId));
        request.setAttribute("subject", subject);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
