package com.janhavi.studentmanagement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ContextServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        ServletContext context = getServletContext();

        String email = context.getInitParameter("email");
        String company = context.getInitParameter("company");

 
        out.println("<html><body>");
        out.println("<h3>ServletContext Example</h3>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Company: " + company + "</p>");
        out.println("</body></html>");
    }
}
