package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactoryCRUD;
import hibernate.Interfaces.CRUDDao;
import hibernate.Topic;
import hibernate.Type;
import hibernate.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class NewFormAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        FactorySearchImpl factorySearch = new FactorySearchImpl();
//        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf(Type.getTypePosition()));
        FactoryCRUD factoryCrud = new FactoryCRUD();
        CRUDDao crudDao = factoryCrud.getTypeOperation(Integer.valueOf(Type.getTypePosition()));
        List<Users> users = crudDao.searchAllUsers();
        request.setAttribute("users", users);
        List<Topic> topics = crudDao.searchAllTopic();
        request.setAttribute("topics", topics);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
