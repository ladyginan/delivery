<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="/resources/css/menu.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Home page</title>
</head>
<header>
    <h1>Home page</h1><br/>
</header>
<body id ="body">
<div class="clearfix"><div class="add">
    <h2 class = "h">Add function</h2>

    <a href="${pageContext.request.contextPath}/waggons/add">Add new waggon</a><br/>
    <a href="${pageContext.request.contextPath}/drivers/add">Add new driver</a><br/>
    <a href="${pageContext.request.contextPath}/points/add">Add way point</a><br/>
    <a href="${pageContext.request.contextPath}/cargoes/add">Add new cargo</a><br/>
    <a href="${pageContext.request.contextPath}/orders/add">Add new order</a><br/>
</div>
    <div class="list">
        <h2 class = "h">List function</h2>

        <a href="${pageContext.request.contextPath}/drivers/list">Drivers list</a><br/>
        <a href="${pageContext.request.contextPath}/waggons/list">Waggons list</a><br/>
        <a href="${pageContext.request.contextPath}/orders/list">Orders list</a><br/>
        <a href="${pageContext.request.contextPath}/status/cargoes">Cargo status</a><br/>
        <a href="${pageContext.request.contextPath}/status/orders">Order status</a><br/>

        <%--<h2>Options for drivers (SOON)</h2>--%>
        <%--<a href="${pageContext.request.contextPath}/drivers/info">Info driver</a><br/>--%>
        <%--<a href="${pageContext.request.contextPath}/drivers/statusEdit">Edit driver's status</a><br/><br/><br/>--%>
    </div>
</div>

<div class="message">
    ${message}
</div>
</body>
</html>