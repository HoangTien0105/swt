<%-- 
    Document   : usertable
    Created on : Jun 7, 2023, 2:03:32 PM
    Author     : user
--%>

<%@page import="java.util.List"%>
<%@page import="users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UserTable Page</title>
    </head>
    <body>
        <%
            String search = request.getParameter("txtSearch");
            if (search == null) {
                search = "";
            }
        %>
        <form action="DispatchServlet">
            <input type="text" name="txtSearch" value="<%= search%>" />
            <input type="submit" value="Search User" name="action" />
        </form>

 

        <%
            List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (listUser != null) {
                if (listUser.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>UserID</th>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Password</th>
                    <th>PhoneNumber</th>
                    <th>DateOfBirth</th>
                    <th>RoleID</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : listUser) {
                %>
                <tr>
            <form action="DispatchServlet">
                <td><%= count++%></td>
                <td>
                    <input type="text" name="userID" value="<%= user.getUserID()%>"/> 
                </td>
                <td>
                    <input type="text" name="userName" value="<%= user.getUsername()%>" />
                </td>
                <td>
                    <input type="text" name="fullName" value="<%= user.getFullname()%>" />
                </td>
                <td><%= user.getPassword()%></td>
                <td>
                    <input type="text" name="phoneNumber" value="<%= user.getPhoneNumber()%>" />
                </td>
                <td>
                    <input type="date" name="dateOfBirth" value="<%= user.getDateOfBirth()%>" />
                </td>
                <td>
                    <input type="number" max="2" min="0" name="roleID" value="<%= user.getRoleID()%>" />
                </td>
                <td>
                    <input type="submit" name="action" value="UpdateUser" /> </br>
                    <input type="hidden" name="txtSearch" value="<%= search%>" />
                </td>
                <td>
                    <input type="submit" name="action" value="DeleteUser" /> </br>                  
                </td>
            </form>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

<%
        }
    }
%>

        <form action="DispatchServlet" method="POST">
            <input type="submit" value="Add User" name="action" />
        </form>

</body>
</html>
