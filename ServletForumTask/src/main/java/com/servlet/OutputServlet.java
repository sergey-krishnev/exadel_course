package com.servlet;

import hibernate.Implementations.AllSubjectDisplayImpl;
import hibernate.Interfaces.IDisplay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class OutputServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (PrintWriter out = resp.getWriter()) {
            String choice = req.getParameter("choice");

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            IDisplay d = new AllSubjectDisplayImpl();

            out.append("<!DOCTYPE html>\r\n")
                    .append("<html>\r\n")
                    .append("		<head>\r\n")
                    .append("			<title>Output type</title>\r\n")
                    .append("		</head>\r\n")
                    .append("		<body>\r\n");
            if (choice != null && !choice.trim().isEmpty()) {
                out.append("	You successfully entered the type.\r\n");

                out.append("</br>");
                out.append("	MultipleParameterValues:\r\n");
                out.append("</br>");

                Enumeration<String> parameterNames = req.getParameterNames();
                StringBuilder stringBuilder = new StringBuilder();
                while (parameterNames.hasMoreElements())
                {
                    String element = parameterNames.nextElement();
                    stringBuilder.append(element);
                    stringBuilder.append(":");
                    stringBuilder.append(req.getParameter(element));
                    stringBuilder.append("</br>");
                }
                out.append(stringBuilder.toString());

                for (String dAll : d.displayAll(choice)) {
                    out.append("<tr>\n" +
                            "        <td>" + dAll + "</td>\n" +
                            "        <br/>");
                }
            } else {
                out.append("	You did not entered a type!\r\n");
            }
            out.append("		</body>\r\n")
                    .append("</html>\r\n");
        }
    }
}
