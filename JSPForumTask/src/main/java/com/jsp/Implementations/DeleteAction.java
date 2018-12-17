package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactoryCRUD;
import hibernate.Interfaces.CRUDDao;
import hibernate.Subject;
import hibernate.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (Type.getTypePosition().equals("0")) {
            request.setAttribute("type", "Query");
        } else request.setAttribute("type", "Criteria");
        FactoryCRUD factoryCrud = new FactoryCRUD();
        CRUDDao crudDao = factoryCrud.getTypeOperation(Integer.valueOf(Type.getTypePosition()));
        String subjectId = request.getParameter("subjectId");
        crudDao.deleteSubjectById(Integer.valueOf(subjectId));
        List<Subject> searchAll = crudDao.searchAll();
        request.setAttribute("searchAll", searchAll);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
