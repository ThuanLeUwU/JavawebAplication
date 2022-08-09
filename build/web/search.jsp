<%-- 
    Document   : search
    Created on : Feb 11, 2022, 9:40:34 AM
    Author     : lthua
--%>

<%--<%@page import="thuanlm.booking.BookingDTO"%>
<%@page import="java.util.List"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>        
        <h1>Search Page</h1>
        <form action="search">
            Search Value <input Type="text" name="txtSearchValue" 
                                value="${param.txtSearchValue}" /><br/> 
            <input type="submit" value="Search" name="btAction" />
        </form><br/>
        <c:set var="searchValue" value = "${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full Name</th>
                            <th>Role</th>   
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="admin" value = "${sessionScope.USERNAME}"/>    
                        <jsp:useBean id="admin" type="java.lang.String" />
                        <c:forEach var="dto" items="${result}" varStatus="count" >
                            <c:set var="user" value = "${dto.username}"/>    
                            <jsp:useBean id="user" type="java.lang.String" />
                            <c:if test="<%=admin.equalsIgnoreCase(user)%>"></c:if>
                            <c:if test="<%=!admin.equalsIgnoreCase(user)%>">
                            <form action="update">


                                <tr>                                
                                    <th>
                                        ${count.count} 
                                        .</th>
                                    <th>
                                        ${dto.username}
                                        <input type="hidden" name="txtUsername" value="${dto.username}" />
                                    </th>
                                    <th>

                                        <input type="text" name="txtPassword" value="${dto.password}" />
                                    </th>
                                    <th>
                                        ${dto.lastname}
                                    </th>
                                    <th>
                                        <input type="checkbox" name="chkAdmin" value="ON" 
                                               <c:if test="${dto.role}">
                                                   checked="checked"
                                               </c:if>
                                               />
                                    </th>  
                                    <td>
                                        <c:url var="delete" value="delete">
                                            <c:param name="btAction" value="Delete"/>
                                            <c:param name="pk" value="${dto.username}"/>
                                            <c:param name="txtSearchValue" value="${searchValue}"/>
                                        </c:url>
                                        <a href="${delete}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update" name="btAction" />
                                        <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                        <%--    <c:url var="update" value="update">
                                                <c:param name="btAction" value="Update"/>
                                                <c:param name="txtUsername" value="${dto.username}"/>
                                                <c:param name="txtPassword" value="${dto.password}"/>
                                                
                                                <c:param name="txtSearchValue" value="${searchValue}"/>
                                            </c:url> 
                                            <input type="submit" value="Update" name="btAction" /> --%>
                                    </td>
                                </tr>

                            </form>
                            </c:if>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test = "${empty result}">
            <h2>
                Not record is matched!!!
            </h2>
        </c:if>
    </c:if>
    <br/> <a href ="shopping">Click here to shopping </a>
    <form action="logoutServlet">
        <input type="submit" value="Logout" name="btAction" />
    </form><br/>
    <%--<% 
        Cookie[] cookie = request.getCookies();
        if(cookie != null) {
            Cookie lastCookie = cookie[cookie.length - 1];
            String username = lastCookie.getName();
            %>
            <font color="red">
                Welcome, <%= username %>
            </font>
            <%
        }       
    %>
    <h1>Search Page</h1>
    <form action="DispatchController">
        Search Value <input Type="text" name="txtSearchValue" 
                            value="<%= request.getParameter("txtSearchValue")%>" /><br/> 
        <input type="submit" value="Search" name="btAction" />
    </form><br/>
    <%
        String searchValue = request.getParameter("txtSearchValue");
        if (searchValue != null) {
            List<BookingDTO> result
                    = (List<BookingDTO>) request.getAttribute("SEARCHRESULT");

                if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Full Name</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (BookingDTO dto : result) {
                        String urlRewritting = "DispatchController?"
                                + "btAction=Delete"
                                + "&pk=" + dto.getUsername()
                                + "&txtSearchValue=" + searchValue;

                %>
            <form action="DispatchController">
                <tr>
                    <td>
                        <%=++count%>
                        .</td>
                    <td>
                        <%= dto.getUsername()%>
                        <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>" />
                    </td>
                    <td>                      
                        <input type="text" name="txtPassword" value="<%= dto.getPassword()%>" />
                    </td>                                      
                    <td>
                        <%= dto.getLastname()%>
                    </td>
                    <td>
                        <input type="checkbox" name="checkRole" value="ON" 
                               <%
                                   if(dto.isRole()) {
                                       %>
                                       checked="checked"
                                       <%
                                   }                                          
                                   %>
                               />
                    </td>                                     
                    <td>
                        <a href=<%= urlRewritting%>>Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="lastSearchValue" value="<%= searchValue %>" />
                        <input type="submit" value="Update" name="btAction" />
                    </td>
                </tr>
            </form>    
            <%
                }//end for traversing dto
            %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <h2>
        No record is matched!!!! 
    </h2>
    <%
            }
        }//check first time for search value
%>--%>
</body>
</html>
