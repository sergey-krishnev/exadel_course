package com.servlet;

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

        try (PrintWriter out = resp.getWriter()) {
            out.append("<!DOCTYPE html>\r\n")
                    .append("<html>\r\n")
                    .append("		<head>\r\n")
                    .append("			<title>Form input type</title>\r\n")
                    .append("		</head>\r\n")
                    .append("		<body>\r\n")
                    .append("			<form action=\"OutputServlet\" method=\"POST\">\r\n")
                    .append("				Enter your type: \r\n")
                    .append("				<input type=\"text\" name=\"choice\" />\r\n")
                    .append("				Enter your output values: </br> \r\n");
            for (int i = 1; i <= 10; i++) {
                out.append("               <input type=\"text\" name=\"output" + i + "\" /></br>\r\n");
            }
            out.append("				<input type=\"submit\" value=\"Submit\" />\r\n")
                    .append("			</form>\r\n")
                    .append("		</body>\r\n")
                    .append("</html>\r\n");
        }
    }
}