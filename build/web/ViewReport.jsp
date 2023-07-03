<%-- 
    Document   : ViewReport
    Created on : Jul 3, 2023, 10:15:57 PM
    Author     : nguyenhuuphuoc
--%>

<%@page import="report.ReportDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 20px;
            }

            h1 {
                color: #333;
                font-size: 24px;
                margin:0 0 20px 0;
                justify-content: center;
                text-align: center;
            }
            table {
                border-collapse: collapse;
                width: 70%;
                margin-left: 200px;
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
        <h1>View Report</h1>
        <% List<ReportDTO> accountList = (List<ReportDTO>) request.getAttribute("accountList"); %>
        <% if (accountList != null && accountList.size() > 0) {%>
        <table border="1">
            <thead>
                <tr>
                    <th>Report ID</th>
                    <th>Report Name</th>
                    <th>Content</th>
                    <th>User ID</th>
                </tr>
            </thead>
            <% for (ReportDTO acc : accountList) {%>
            <tbody>
            <form action="DispatchServlet">
                <td><%= acc.getReportID()%></td>
                <td><%= acc.getReportName()%></td>
                <td><%= acc.getContent()%></td>
                <td><%= acc.getUserID()%></td>
            </form>
        </tbody>
        <% }%> 
    </table>
    <% } else { %>
    <h2>No record is Found!!!</h2>
    <% }%>
</body>
</html>
