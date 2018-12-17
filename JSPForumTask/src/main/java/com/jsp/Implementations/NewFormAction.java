package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Interfaces.ISearch;
import hibernate.Topic;
import hibernate.Type;
import hibernate.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class NewFormAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FactorySearchImpl factorySearch = new FactorySearchImpl();
        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf(Type.getTypePosition()));
        List<Users> users = searchBy.searchAllUsers();
        request.setAttribute("users", users);
        List<Topic> topics = searchBy.searchAllTopic();
        request.setAttribute("topics", topics);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
