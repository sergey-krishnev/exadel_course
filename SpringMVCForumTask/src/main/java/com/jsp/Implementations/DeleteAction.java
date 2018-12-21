package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Factories.FactoryCRUD;
import hibernate.dao.interfaces.CRUDDao;
import hibernate.model.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FactoryCRUD factoryCrud = new FactoryCRUD();
        CRUDDao crudDao = factoryCrud.getTypeOperation(Integer.valueOf(Type.getTypePosition()));
        request.setAttribute("type", crudDao.getType());
        String subjectId = request.getParameter("subjectId");
        crudDao.deleteSubjectById(Integer.valueOf(subjectId));
        List<Subject> searchAll = crudDao.searchAll();
        request.setAttribute("searchAll", searchAll);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
