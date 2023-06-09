<%-- 
    Document   : hrmanager
    Created on : Jun 1, 2023, 6:42:16 PM
    Author     : user
--%>

<%@page import="users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HR Manager</title>
    </head>
    <body>
        <%
            UserDTO loginuser = (UserDTO) session.getAttribute("LOGIN_USER");
            if(loginuser == null || loginuser.getRoleID()!=0){
                response.sendRedirect("login.html");
                return;
            }
        %>
        
        Fullname: <%=loginuser.getFullname()%> </br>
        <form action="DispatchServlet">
        <input type="submit" value="Usertable" name="action" /> </br>
        <input type="submit" value="Contract" name="action" /> </br>
        <input type="submit" value="OTleaves" name="action" /> 
        </form>
        
    </body>
</html>
