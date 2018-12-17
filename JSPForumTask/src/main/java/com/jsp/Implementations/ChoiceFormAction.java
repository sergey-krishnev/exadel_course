package com.jsp.Implementations;

import com.jsp.Interfaces.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChoiceFormAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("selectType.jsp").forward(request, response);
    }
}
