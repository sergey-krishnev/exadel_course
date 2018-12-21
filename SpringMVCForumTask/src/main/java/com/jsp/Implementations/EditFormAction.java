package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactoryCRUD;
import hibernate.dao.interfaces.CRUDDao;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;

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
        String subjectId = request.getParameter("subjectId");
        setSubjectId(Integer.valueOf(subjectId));
        FactoryCRUD factoryCrud = new FactoryCRUD();
        CRUDDao crudDao = factoryCrud.getTypeOperation(Integer.valueOf(Type.getTypePosition()));
        List<Users> users = crudDao.searchAllUsers();
        request.setAttribute("users", users);
        List<Topic> topics = crudDao.searchAllTopic();
        request.setAttribute("topics", topics);
        Subject subject = crudDao.searchBySubjectId(Integer.valueOf(subjectId));
        request.setAttribute("subject", subject);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
