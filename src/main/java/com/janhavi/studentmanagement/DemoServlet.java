package com.janhavi.studentmanagement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class DemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");



        
        
        String name = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Write response content
        out.println("<html><body>");
        out.println("<h1> Name: " + name + "</h1>");
        out.println("<h1> Password: " + password + "</h1>");
        
        
        out.println("</body></html>");

        out.close();
    }
}
