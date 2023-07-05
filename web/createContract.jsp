<%-- 
    Document   : createContract
    Created on : Jul 4, 2023, 11:52:30 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Contract Page</title>
    </head>
    <body>
        <h2>Create new contract</h2>
        <form action="DispatchServlet" method="POST">
            ContractID <input type="text" name="txtContractID" value="" /> <br>
            StaffType <input type="text" name="txtStaffType" value="" /> <br>
            Contract Start Date <input type="date" name="contractStartDate" value="" /> <br>
            Contract End Date <input type="date" name="contractEndDate" value="" /> <br>
            Salary <input type="text" name="salary" value="" /> <br>
            UserID <input type="text" name="userID" value="" /> <br>
            <input type="submit" value="Create Contract" name="action" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
