package com.jsp.Implementations;

import com.jsp.Interfaces.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewFormAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.getRequestDispatcher("update.jsp").forward(request, response);
            return "success";
        } catch (RuntimeException e) {
            request.setAttribute("errorMessage", e.getMessage());// to show exception msg in jsp.
            //log exception to console or file here..
            return "failure";
        }
    }
}
