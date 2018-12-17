package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactoryCRUD;
import hibernate.Interfaces.CRUDDao;
import hibernate.Subject;
import hibernate.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomeAction implements Action {
    private static String LIST_RECORDS = "index.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        FactorySearchImpl factorySearch = new FactorySearchImpl();
//        ISearch searchBy = factorySearch.getSearchImpl(Integer.valueOf("0"));
        FactoryCRUD factoryCrud = new FactoryCRUD();
        CRUDDao crudDao = factoryCrud.getTypeOperation(Integer.valueOf("0"));
        if (Type.getTypePosition().equals("0")) {
            request.setAttribute("type", "Query");
        } else request.setAttribute("type", "Criteria");

        List<Subject> searchAll = crudDao.searchAll();
        request.setAttribute("searchAll", searchAll);
        request.getRequestDispatcher(LIST_RECORDS).forward(request, response);
    }


}
