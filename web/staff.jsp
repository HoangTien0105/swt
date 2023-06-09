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
    </head>
    <body>
        <%
            UserDTO loginuser = (UserDTO)session.getAttribute("LOGIN_USER");
            if(loginuser==null || loginuser.getRoleID()!=2){
                response.sendRedirect("login.html");
                return;
            }
        %>
        Fullname: <%=loginuser.getFullname()%>
    </body>
</html>
