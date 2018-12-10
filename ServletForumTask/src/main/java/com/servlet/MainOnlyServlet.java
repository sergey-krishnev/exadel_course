package com.servlet;

import hibernate.Implementations.AllSubjectDisplayImpl;
import hibernate.Interfaces.IDisplay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainOnlyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
       out.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Form input type</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n")
                .append("			<form action=\"MainOnlyServlet\" method=\"POST\">\r\n")
                .append("				Enter your type: \r\n")
                .append("				<input type=\"text\" name=\"choice\" />\r\n")
                .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
                .append("			</form>\r\n")
                .append("		</body>\r\n")
                .append("</html>\r\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String choice = req.getParameter("choice");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        IDisplay d = new AllSubjectDisplayImpl();

        out.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Output type</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n");
        if (choice != null && !choice.trim().isEmpty()) {
            out.append("	You successfully entered the type.\r\n");
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