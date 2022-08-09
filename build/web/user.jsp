<%-- 
    Document   : user
    Created on : Mar 12, 2022, 2:24:31 AM
    Author     : lthua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>
    <body>
        <h1 style="color: blue">Welcome ${sessionScope.FULLNAME}</h1>
        <a href ="shopping">Click here to shopping </a>
        <form action="logoutServlet">
            <input type="submit" value="Logout" name="btAction" />
        </form>
    </body>
</html>
