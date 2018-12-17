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

public class ActionServlet extends HttpServlet {

    private Map<String,Action> actionMap = new HashMap<String, Action>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        actionMap.put("add", new AddAction());
        actionMap.put("update", new UpdateAction());
        actionMap.put("delete", new DeleteAction());
        actionMap.put("editForm", new EditFormAction());
        actionMap.put("newForm", new NewFormAction());
        actionMap.put("choiceForm", new ChoiceFormAction());
        actionMap.put("selectType", new SelectAction());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionKey = request.getParameter("action");
        Action action = actionMap.get(actionKey);
        try {
            action.execute(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
