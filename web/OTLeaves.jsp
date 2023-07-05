<%-- 
    Document   : OTLeaves
    Created on : Jun 7, 2023, 2:52:41 PM
    Author     : user
--%>

<%@page import="otleaves.OTLeavesDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OT Leaves Page</title>
    </head>
    <body>
        <% 
            String searchValue = request.getParameter("txtSearchLeave");
            if(searchValue == null){
                searchValue = "";
            }
        %>
        <form action="DispatchServlet">
            <input type="text" name="txtSearchLeave" value="<%= searchValue%>" /> 
            <input type="submit" value="SearchLeave" name="action" />
        </form>
        
        <%
            List<OTLeavesDTO> listLeaves = (List<OTLeavesDTO>) request.getAttribute("LIST_OTLEAVES");
            if(listLeaves!=null){
                if(listLeaves.size()>0){
        %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>LeaveID</th>
                                <th>LeaveStartDate</th>
                                <th>LeaveEndDate</th>
                                <th>UserID</th>
                                <th>RoleID</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <%
                            int count = 1;
                            for(OTLeavesDTO list: listLeaves){
                                %>
                        <tbody>
                        
                            <tr>
                                <form action="DispatchServlet">
                                <td><%= count++%></td>
                                <td>
                                    <%= list.getLeaveID()%>
                                    <input type="hidden" name="leaveID" value="<%= list.getLeaveID()%>" />
                                </td>
                                <td><%= list.getLeaveStartDate()%></td>
                                <td><%= list.getLeaveEndDate()%></td>
                                <td><%= list.getUserID()%></td>
                                <td><%= list.getRoleID()%></td>
                                <td>
                                    <input type="submit" value="DeleteLeave" name="action" />
                                    <input type="hidden" name="txtSearchLeave" value="<%= searchValue%>" />
                                </td>
                                </form>
                            </tr>
 
 
                        </tbody>
                                   <%
                            }
                        %>
                    </table>

                    <%
                }
            }
        %>
    </body>
</html>
