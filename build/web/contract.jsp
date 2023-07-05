<%-- 
    Document   : hrcontract
    Created on : Jun 7, 2023, 2:50:59 PM
    Author     : user
--%>

<%@page import="contracts.ContractDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contract Page</title>
    </head>
    <body>
        <%
            String searchContract = request.getParameter("txtSearchContract");
            if (searchContract == null) {
                searchContract = "";
            }
        %>
        <form action="DispatchServlet">
            <input type="text" name="txtSearchContract" value="<%= searchContract%>" /> 
            <input type="submit" value="SearchContract" name="action" />
            <input type="submit" value="AddContract" name="action" />
        </form>
        
        <%
            List<ContractDTO> contractList = (List<ContractDTO>) request.getAttribute("LIST_CONTRACT");
            if(contractList != null){
                if(contractList.size()>0) {
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>ContractID</th>
                                <th>Staff Type</th>
                                <th>Contract Start Date</th>
                                <th>Contract End Date</th>
                                <th>Salary</th>
                                <th>UserID</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <%
                            int count = 1;
                            for(ContractDTO contract: contractList){
                        %>
                        <tbody>
                            <form action="DispatchServlet" method="POST">
                                <tr>
                                    <td><%= count++%></td>
                                    <td>
                                        <input type="text" name="contractID" value="<%= contract.getContractID()%>" />
                                    </td>
                                    <td><%= contract.getStaffType()%></td>
                                    <td><%= contract.getStartDate()%></td>
                                    <td><%= contract.getEndDate()%></td>
                                    <td><%= contract.getSalary()%></td>
                                    <td><%= contract.getUserID()%></td>
                                    <td>
                                        <input type="submit" value="Delete Contract" name="action" />
                                        <input type="hidden" name="txtSearchContract" value="<%= searchContract%>" />
                                    </td>
                                </tr>
                            </form>
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
