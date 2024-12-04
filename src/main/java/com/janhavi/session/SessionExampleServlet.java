package com.janhavi.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SessionExampleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        session.setAttribute("username", "JohnDoe");
        session.setAttribute("role", "admin");

        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        out.println("<h1>Session Information:</h1>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Role: " + role + "</p>");
        out.println("<p>Created at: " + new Date(session.getCreationTime()) + "</p>");
        out.println("<p>Last accessed at: " + new Date(session.getLastAccessedTime()) + "</p>");

        session.setMaxInactiveInterval(600); 
    }
}