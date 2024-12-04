package com.janhavi.studentmanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
        	  request.setAttribute("error", "Please enter all fields!");
              request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        try {
            StudentDAO studentDAO = new StudentDAO();
            if (studentDAO.checkIfUserExists(email)) {
                request.setAttribute("error", "User with this email already exists!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            } else {
                User newUser = new User(0, name, email, password);
                studentDAO.insertUser(newUser);
                
                response.sendRedirect("/StudentManagement/login.jsp");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error adding student. Please try again.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
