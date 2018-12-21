package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactoryCRUD;
import hibernate.dao.interfaces.CRUDDao;
import hibernate.model.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomeAction implements Action {
    private static String LIST_RECORDS = "index.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FactoryCRUD factoryCrud = new FactoryCRUD();
        CRUDDao crudDao = factoryCrud.getTypeOperation(Integer.valueOf(Type.getTypePosition()));
        request.setAttribute("type", crudDao.getType());

        List<Subject> searchAll = crudDao.searchAll();
        request.setAttribute("searchAll", searchAll);
        request.getRequestDispatcher(LIST_RECORDS).forward(request, response);
    }


}
