package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Type;
import hibernate.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditFormAction implements Action {

    private static Integer SUBJECT_ID;

    public static Integer getSubjectId() {
        return SUBJECT_ID;
    }

    public static void setSubjectId(Integer subjectId) {
        SUBJECT_ID = subjectId;
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FactorySearchImpl factorySearch = new FactorySearchImpl();
        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));
        String subjectId = request.getParameter("subjectId");
        setSubjectId(Integer.valueOf(subjectId));
        List<Users> users = searchBy.searchAllUsers();
        request.setAttribute("users", users);
        List<Topic> topics = searchBy.searchAllTopic();
        request.setAttribute("topics", topics);
        Subject subject = searchBy.searchBySubjectId(Integer.valueOf(subjectId));
        request.setAttribute("subject", subject);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
