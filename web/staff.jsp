<%-- 
    Document   : staff
    Created on : Jun 1, 2023, 6:42:28 PM
    Author     : user
--%>

<%@page import="users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff page</title>
        <style>
            .form-group {
                padding: 10px 16px;
                background-color: #4CAF50;
                border: none;
                color: white;
                cursor: pointer;
                border-radius: 4px;
                margin: 10px 0 0 20px;
            }

            .form-group-1 {
                padding: 10px 16px;
                background-color: #4CAF50;
                border: none;
                color: white;
                cursor: pointer;
                border-radius: 4px;
                margin: 10px 0 0 20px;
                width: 82.9px;
            }
        </style>
    </head>
    <body>
        <%
            UserDTO loginuser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginuser == null || loginuser.getRoleID() != 2) {
                response.sendRedirect("login.html");
                return;
            }
        %>
        Fullname: <%=loginuser.getFullname()%> </br>
        <form  action="DispatchServlet">
            <input class="form-group" type="submit" value="ViewInfo" name="action" /> </br>
            <input class="form-group-1" type="submit" value="Report" name="action" />
        </form>
    </body>
</html>
