<%-- 
    Document   : admin
    Created on : Mar 12, 2022, 2:23:25 AM
    Author     : lthua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <h1 style="color: blue">Welcome Admin ${sessionScope.FULLNAME}</h1>
        <a href="searchPage">Click here to search account</a>      
       <a href ="shopping">Click here to shopping </a>
        <form action="logoutServlet">
            <input type="submit" value="Logout" name="btAction" />
        </form>
    </body>
</html>
