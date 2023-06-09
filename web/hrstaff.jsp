<%-- 
    Document   : hrstaff
    Created on : Jun 1, 2023, 6:42:23 PM
    Author     : user
--%>

<%@page import="users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HR Staff Page</title>
    </head>
    <body>
        <% UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if(loginUser == null || loginUser.getRoleID()!=1){
                response.sendRedirect("login.html");
                return;
            }
        %>
        
        Full name: <%= loginUser.getFullname()%>
    </body>
</html>
