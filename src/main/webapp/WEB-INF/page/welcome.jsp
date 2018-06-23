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
    <link rel="stylesheet" href="/resources/bootstrap/js/bootstrap.min.js">
    <link rel="stylesheet" href="/resources/bootstrap/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="/resources/myCss/menu.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Home page</title>
</head>
<header>
    <h1>Home page</h1><br/>
</header>
<body class = rainbow>
<div class = "d-flex flex-row justify-content-center">
    <div class = "p-2 col-sm-4">
        <h4 class = "list-group-item">Add function</h4>
        <a class="list-group-item list-group-item-action list-group-item-light"
       href="${pageContext.request.contextPath}/waggons/add">Add new waggon</a>
        <a class="list-group-item list-group-item-action list-group-item-light"
       href="${pageContext.request.contextPath}/drivers/add">Add new driver</a>
        <a class="list-group-item list-group-item-action list-group-item-light"
       href="${pageContext.request.contextPath}/points/add">Add way point</a>
        <a class="list-group-item list-group-item-action list-group-item-light"
       href="${pageContext.request.contextPath}/cargoes/add">Add new cargo</a>
        <a class="list-group-item list-group-item-action list-group-item-light"
       href="${pageContext.request.contextPath}/orders/add">Add new order</a>
    </div>
    <div class = "p-2 col-sm-4">
        <h4 class = "list-group-item">List function</h4>
        <a class="list-group-item list-group-item-action list-group-item-light"
        href="${pageContext.request.contextPath}/drivers/list">Drivers list</a>
        <a class="list-group-item list-group-item-action list-group-item-light"
           href="${pageContext.request.contextPath}/waggons/list">Waggons list</a>
        <a class="list-group-item list-group-item-action list-group-item-light"
           href="${pageContext.request.contextPath}/orders/list">Orders list</a>
        <a class="list-group-item list-group-item-action list-group-item-light"
           href="${pageContext.request.contextPath}/status/cargoes">Cargo status</a>
        <a class="list-group-item list-group-item-action list-group-item-light"
           href="${pageContext.request.contextPath}/status/orders">Order status</a>
    </div>
</div>

<div class = "message" align="center" >
  ${message}
</div>
</body>
</html>