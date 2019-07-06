<%-- 
    Document   : welcome
    Created on : Nov 20, 2018, 4:20:01 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/default.css">
    </head>
    <body>
        <h1>Welcome ${sessionScope.UserLoggedIn}</h1>
        <a href="logout">Logout</a>|
        <a href="showingcategorypage">Add Table</a>|
        <a href="showcustomerinfo">Add Customer</a>|
        <a href="showproductpage">Add Product</a>
        <a href="<%=request.getContextPath() %>">Customer</a>
    </body>
</html>
