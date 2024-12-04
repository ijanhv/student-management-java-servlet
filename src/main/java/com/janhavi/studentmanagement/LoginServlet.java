package com.janhavi.studentmanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            StudentDAO studentDAO = new StudentDAO();
            if(!studentDAO.checkIfUserExists(email)) {
            	request.setAttribute("error", "User doesn't exist!.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
           if(studentDAO.loginUser(email, password)) {
        	   response.sendRedirect("/StudentManagement/students");
           } else {
        	   request.setAttribute("error", "Wrong email or password");
               request.getRequestDispatcher("/login.jsp").forward(request, response);
           }
           
        } catch (Exception e) {
            request.setAttribute("error", "Error logging in. Please try again.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
