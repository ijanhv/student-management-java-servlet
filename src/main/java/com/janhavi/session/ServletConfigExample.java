package com.janhavi.session;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;

@WebServlet(
    urlPatterns = "/config",
    initParams = {
        @WebInitParam(name = "database", value = "mysql"),
        @WebInitParam(name = "username", value = "admin")
    }
)
public class ServletConfigExample extends GenericServlet {
    
    private static final long serialVersionUID = 1L;

	@Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        

        PrintWriter writer = res.getWriter();
        

        String database = config.getInitParameter("database");
        String username = config.getInitParameter("username");
        

        writer.println("Database: " + database);
        writer.println("Username: " + username);
    }
}