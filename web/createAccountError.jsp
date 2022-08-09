<%-- 
    Document   : createAccountError
    Created on : Mar 2, 2022, 9:44:17 AM
    Author     : lthua
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="" method="POST">
            <c:set var="errors" value="${requestScope.CREATEERRORS}" />
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}" />(e.g. 6 - 20 chars)<br/>
            <c:if test="${not empty errors.usernameLengthErr}" >
                <font>
                ${errors.usernameLengthErr}
                </font><br/>
            </c:if>
            <c:if test="${not empty errors.usernameIssExisted}" >
                <font>
                ${errors.usernameIssExisted}
                </font><br/>
            </c:if>   
            Password* <input type="text" name="txtPassword" value="" />(e.g. 6 - 20 chars)<br/>
            <c:if test="${not empty errors.passwordLengthErr}" >
                <font>
                ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
            Confirm* <input type="text" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNot}" >
                <font>
                ${errors.confirmNot}
                </font><br/>
            </c:if>
                Full Name* <input type="text" name="txtFullname" value="${param.txtFullname}" />(e.g. 2 - 50 chars)<br/>
            <c:if test="${not empty errors.fullNameLengthErr}" >
                <font>
                ${errors.fullNameLengthErr}
                </font><br/>
            </c:if>
            <input type="submit" value="Create New Account" name="btAction" />
        </form>
    </body>
</html>
