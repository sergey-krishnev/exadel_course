package com.jsp;

import com.jsp.Implementations.*;
import com.jsp.Interfaces.Action;
import hibernate.Factories.FactorySearchImpl;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainServlet extends HttpServlet {

    private Map<String,Action> actionMap = new HashMap<String, Action>();
    private static String LIST_RECORDS = "index.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        actionMap.put("home", new HomeAction());
        actionMap.put("add", new AddAction());
        actionMap.put("update", new UpdateAction());
        actionMap.put("delete", new DeleteAction());
        actionMap.put("editForm", new EditFormAction());
        actionMap.put("newForm", new NewFormAction());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionKey = req.getParameter("action");
        Action action = actionMap.get(actionKey);
        try {
            String view = action.execute(req, resp);
            System.out.println(view);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Here, if view is if failure then, forward to jsp, to available request attributes in jsp.
        //      if view is success redirect to jsp..
    }

//        String forward = "";
//
//        String action = req.getParameter("action");

//        if (action.equalsIgnoreCase("delete")) {
//            String subjectId = req.getParameter("subjectId");
//            searchBy.deleteSubjectById(Integer.valueOf(subjectId));
//            forward = LIST_RECORDS;
//            List<Subject> searchAll = searchBy.searchAll();
//            req.setAttribute("searchAll", searchAll);
//        } else if (action.equalsIgnoreCase("edit")){
//            forward = INSERT_OR_EDIT;
//            String subjectId = req.getParameter("subjectId");
//            Subject subject = searchBy.searchBySubjectId(Integer.valueOf(subjectId));
//            req.setAttribute("subject", subject);
//        } else {
//            forward = INSERT_OR_EDIT;
//        }
}
