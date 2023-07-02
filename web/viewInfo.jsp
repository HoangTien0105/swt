<%-- 
    Document   : viewInfo
    Created on : Jul 1, 2023, 7:36:17 AM
    Author     : nguyenhuuphuoc
--%>


<%@page import="java.util.List"%>
<%@page import="users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP page</title>
    </head>
    <body>
        <h1>View Account</h1>
        <div>
            <form action="DispatchServlet" method="POST">
                <input style="border-radius:4px;border:1px solid" type="text" name="txtSearch">
                <input type="submit" value="searchAccount" name="action">
            </form></br>
        </div>
        <% List<UserDTO> accountList = (List<UserDTO>) request.getAttribute("accountList"); %>
        <% if (accountList != null && accountList.size() > 0) { %>
        <table border="1">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Full Name</th>
                    <th>Password</th>
                    <th>Phone Number</th>
                    <th>Date of Birth</th>
                    <th>Role ID</th>
                </tr>
            </thead>
            <% for (UserDTO acc : accountList) {%>
            <tbody>
            <form action="DispatchServlet">
                <td><%= acc.getUserID()%></td>
                <td><%= acc.getUsername()%></td>
                <td><%= acc.getFullname()%></td>
                <td> <input type="password" name="txtPassword" value="<%= acc.getPassword()%>" /></td>
                <td><%= acc.getPhoneNumber()%></td>
                <td><%= acc.getDateOfBirth()%></td>
                <td><%= acc.getRoleID()%></td>
            </form>
        </tbody>
        <% } %> 
    </table>  
    <% } else { %>
    <h2>No record is matched!!!</h2>
    <% }%>
</body>
</html>
