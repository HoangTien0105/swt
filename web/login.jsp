<%-- 
    Document   : login
    Created on : Jun 1, 2023, 6:36:02 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Please login</h2>
        <form action="DispatchServlet" method="POST">
            Username <input type="text" name="txtUsername" value="" /> </br>
            Password <input type="password" name="txtPassword" value="" /> </br>
            <input type="submit" value="LogIn" name="action" />
            <input type="reset" value="reset" />
        </form>
        <%
            String error = (String) request.getAttribute("ERROR");
            if(error==null){
                error="";
            }
        %>
        <%= error%>
    </body>
</html>
