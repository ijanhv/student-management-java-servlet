<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" 
    import="java.util.Date, java.util.Random" session="true" 
    buffer="8kb" autoFlush="true" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head> 
<body class="max-w-2xl w-full mx-auto h-screen flex flex-col items-center justify-center">
    <h2 class="text-3xl font-semibold">Login</h2>
    
    <form action="login" method="post" class="flex flex-col  w-full gap-1 mt-10">
        
       
        <label for="email">Email:</label>
        <input class="border border-gray-300" type="email" id="email" name="email" required><br>
    
        <label for="password">Password:</label>
        <input class="border border-gray-300"  type="password" id="password" name="password" required><br>

        <button class="bg-emerald-400 p-3 rounded-md text-white" type="submit">Register</button>
    </form>


   <c:if test="${not empty error}">
        <p class="text-red-500">${error}</p>
    </c:if>
</body>
</html>