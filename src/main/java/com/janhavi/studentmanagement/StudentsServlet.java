package com.janhavi.studentmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        UserDAO userDAO = new StudentDAO();
        List<User> users = userDAO.getAllUsers();
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student List</title>");
        out.println("<style>");
        out.println("table { border-collapse: collapse; width: 50%; margin: 20px auto; }");
        out.println("th, td { border: 1px solid black; padding: 8px; text-align: center; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("a { display: block; text-align: center; margin: 20px; text-decoration: none; color: white; background-color: #4CAF50; padding: 10px; border-radius: 5px; width: 150px; margin-left: auto; margin-right: auto; }");
        out.println("a:hover { background-color: #45a049; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 style='text-align: center;'>Student List</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("</tr>");

        for (User user : users) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getName() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<a href='/StudentManagement/register.jsp'>Add New Student</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
