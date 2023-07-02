<%-- 
    Document   : createUser
    Created on : Jun 28, 2023, 2:38:10 PM
    Author     : user
--%>

<%@page import="users.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User Page</title>
    </head>
    <body>
        <h2>Create new user</h2>
        <%
            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if(userError==null) userError = new UserError();
        %>
        <form action="DispatchServlet" method="POST">
            UserID <input type="text" name="txtUserID" value="" required="" /> <%= userError.getUserIDError()%> <br> 
            Username <input type="text" name="txtUsername" value="" required=""/> <%= userError.getUsernameError()%>  <br>
            Fullname <input type="text" name="txtFullname" value="" required=""/> <%= userError.getFullNameError()%>  <br>
            Password <input type="password" name="txtPassword" value="" required=""/> <%= userError.getPasswordError()%>  <br>
            Confirm Password <input type="password" name="txtConfirm" value="" /> <%= userError.getConfirmError()%>  <br> 
            PhoneNumber <input type="text" name="txtPhoneNumber" value="" required=""/> <%= userError.getPhoneNumberError()%>  <br>
            DateOfBirth <input type="date" name="dateOfBirth" value="" required=""/> <%= userError.getDateOfBirthError()%>  <br>
            RoleID <input type="number" min="0" max="2" name="roleID" value="2" /> <%= userError.getRoleIDError()%>  <br>
            <input type="submit" value="CreateUser" name="action" />
            <input type="reset" value="Reset" />
            <%= userError.getError()%> 
        </form>
    </body>
</html>
