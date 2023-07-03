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
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 20px;
            }

            h1 {
                color: #333;
                font-size: 24px;
                margin-bottom: 20px;
                text-align: center;
            }

            .search-form {
                margin:0 0 20px 0;
            }

            .search-form input[type="text"] {
                border-radius: 4px;
                border: 1px solid #ccc;
                padding: 5px;
            }

            .search-form input[type="submit"] {
                background-color: #4CAF50;
                border: none;
                color: white;
                padding: 6px 10px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                border-radius: 4px;
                cursor: pointer;
            }
            table {
                border-collapse: collapse;
                width: 70%;
            }

            th, td {
                border: 1px solid black;
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #e0e0e0;
            }
        </style>
    </head>
    <body>
        <h1>View Account</h1>
        <div class="search-form">
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
                <%-- <td>
                     <%
                         int role = acc.getRoleID();
                         if (role == 0) {
                             out.println("HR MANAGER");
                         } else if (role == 1) {
                             out.println("HR STAFF");
                         } else {
                             out.println("STAFF");
                         }
                     %>
                 </td> --%>
            </form>
        </tbody>
        <% } %> 
    </table>  
    <% } else { %>
    <h2>No record is Found!!!</h2>
    <% }%>
</body>
</html>

