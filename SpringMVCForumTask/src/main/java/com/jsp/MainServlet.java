package com.jsp;

import com.jsp.Implementations.*;
import com.jsp.Interfaces.Action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Action action = new HomeAction();
        try {
            action.execute(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
