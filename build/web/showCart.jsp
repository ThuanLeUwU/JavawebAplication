<%-- 
    Document   : showCart
    Created on : Feb 21, 2022, 10:14:46 AM
    Author     : lthua
--%>

<%@page import="java.util.Map"%>
<%@page import="thuanlm.cart.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Technology Store</title>
    </head>
    <body>
        <h1>TECHNOLOGY STORE</h1>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart}">
            <h3>Your Cart include</h3>
            <form action="remove" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Title</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${cart.items}" varStatus="count">
                           
                        <form action="remove" method="POST">

                            <tr>
                                <td>
                                    ${count.count}
                                    .</td>
                                <td>    
                                ${item.key}
                                </td>
                                <td>
                                    ${item.value}
                                </td>
                                <td>
                                           <input type="checkbox" name="chkItem" 
                                                  value="${item.key}" />
                                       </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="3">
                                <a href="shopping">Add More To Your Cart</a>
                            </td>
                            <td>
                                <input type="submit" value="Remove Selected Item" name="btAction" />
                            </td>                    
                        </tr>
                    </form>
                    </tbody>
                </table>

                <form action="logoutServlet">
                    <input type="submit" value="Logout" name="btAction" />

                </c:if>
                <c:if test="${empty cart}">
                    <h2>No Cart</h2>
                    <form action="logoutServlet">
                        <input type="submit" value="Logout" name="btAction" />
                    </c:if>
                    <%--      <h1>SoftWare Engineer</h1>
                           <h3>Your Cart Include</h3>
                           <c:set var="session" value="${sessionScope}"/>
                           <c:if test="${not empty session}">
                               <c:set var="result" value="${requestScope.CART}"/>            
                               <c:if test="${not empty result}">
                                   Map<String, Integer> items = 
                               </c:if>
                           </c:if> --%>
                    <%--       <h1>SoftWare Engineer</h1>
                           <h3>Your Cart Include</h3>
                           <%
                               //1. Cust goes to cart place 
                               if (session != null) {
                                   //2. Cust takes his/her cart 
                                   CartObject cart = (CartObject) session.getAttribute("CART");
                                   if (cart != null) {
                                       Map<String, Integer> items = cart.getItems();
                                       if (items != null) {
                           %>
                           <form action="remove">
                           <table border="1">
                               <thead>
                                   <tr>
                                       <th>No.</th>
                                       <th>Title</th>
                                       <th>Quantity</th>
                                       <th>Action</th>
                                   </tr>
                               </thead>
                               <tbody>
                                   <%
                                       int count = 0;
                                       for (String id : items.keySet()) {
                                   %>
                                   <tr>
                                       <td>
                                           <%= ++count%>
                                           .</td>
                                       <td>
                                           <%= id%>
                                       </td>
                                       <td>
                                           <%= items.get(id)%>
                                       </td>
                                       <td>
                                           <input type="checkbox" name="chkItem" 
                                                  value="<%= id %>" />
                                       </td>
                                   </tr>
                                   <%
                                       }
                                   %>                
                                   <tr>
                                       <td colspan="3">
                                           <a href="shopping">Add More Books To Your Cart</a>
                                       </td>
                                       <td>
                                           <input type="submit" value="Remove Selected Item" name="btAction" />
                                       </td>
                                       
                                   </tr>
                                   
                               </tbody>
                               
                           </table>
                                   
                                   </form>
                                   <form action="logoutServlet">
                           <input type="submit" value="Logout" name="btAction" />
                       </form><br/>
                           <%
                                       }

                    return;
                } 
            }
        %>
        <h2>No Cart !!!</h2>
        <form action="logoutServlet">
        <input type="submit" value="Logout" name="btAction" />
    </form><br/>--%>
                    </body> 
                    </html>
