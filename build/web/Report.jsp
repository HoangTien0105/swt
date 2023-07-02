<%-- 
    Document   : Report
    Created on : Jul 2, 2023, 10:20:15 PM
    Author     : nguyenhuuphuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Report</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f1f1f1;
            }
            h1{
                text-align: center;
            }

            .container {
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                background-color: #ffffff;
                border: 1px solid #dddddd;
                border-radius: 4px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                margin-top: 45px;
            }

            .form-group {
                margin: 0 21px 20px 0;

            }

            .form-group label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            .form-group input[type="text"],
            .form-group textarea {
                width: 100%;
                padding: 8px;
                border: 1px solid #cccccc;
                border-radius: 4px;
            }

            .form-group textarea {
                resize: vertical;
            }

            .form-group button {
                padding: 10px 16px;
                background-color: #4CAF50;
                border: none;
                color: white;
                cursor: pointer;
                border-radius: 4px;
            }

            .form-group button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
    <body>
        <div class="container">
            <h1>Create Report</h1>
            <c:set var="errors" value="${requestScope.CREATE_ERROR}"/>
            <form action="DispatchServlet" method="post">
                <div class="form-group">
                    <label for="reportID">Report ID:</label>
                    <input type="text" id="reportID" name="txtreportID" value="${requestScope.txtreportID}" required>
                    <c:if test="${not empty errors.reportIDLengthErr}">
                        <font style="color: red">${errors.reportIDLengthErr}</font></br>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="reportName">Report Name:</label>
                    <input type="text" id="reportName" name="txtreportName" value="${requestScope.txtreportName}" required>
                    <c:if test="${not empty errors.reportNameLengthErr}">
                        <font style="color: red">${errors.reportNameLengthErr}</font></br>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="content">Content:</label>
                    <textarea id="content" name="txtcontent" rows="4" value="${requestScope.txtcontent}" required></textarea>
                    <c:if test="${not empty errors.contentLengthErr}">
                        <font style="color: red">${errors.contentLengthErr}</font></br>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="userID">User ID:</label>
                    <input type="text" id="userID" name="txtuserID" value="${requestScope.txtuserID}" required>
                    <c:if test="${not empty errors.userIDLengthErr}">
                        <font style="color: red">${errors.userIDLengthErr}</font></br>
                    </c:if>
                </div>
                <div class="form-group">
                    <button type="submit" value="CreateNewForm" name="action">Submit</button>
                </div>
            </form>
        </div>
    </body>
</body>
</html>
