package com.jsp.Implementations;

import com.jsp.Interfaces.Action;
import hibernate.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type = request.getParameter("type");
        Type.setTypePosition(type);
        response.sendRedirect("/MainServlet");
    }
}
