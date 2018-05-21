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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Home page</title>
</head>
<body>
<h1>Home page</h1><br/>

<h2>Options for company workers</h2>

        <a href="${pageContext.request.contextPath}/drivers/add.html">Add new driver</a><br/>
        <a href="${pageContext.request.contextPath}/drivers/list.html">Driver list</a><br/>
        <a href="${pageContext.request.contextPath}/waggons/add.html">Add new waggon</a><br/>
        <a href="${pageContext.request.contextPath}/waggons/list.html">Waggon list</a><br/>
        <a href="${pageContext.request.contextPath}/cargoes/add.html">Add new cargo</a><br/>
<h3>Orders</h3>
        <a href="${pageContext.request.contextPath}/orders/add.html">Add new order</a><br/>
        <a href="${pageContext.request.contextPath}/orders/list.html">Orders list</a><br/>
        <a href="${pageContext.request.contextPath}/points/add.html">points add</a><br/>
<h2>Options for drivers</h2>
        <a href="${pageContext.request.contextPath}/drivers/info.html">Info driver</a><br/>
        <a href="${pageContext.request.contextPath}/drivers/statusEdit.html">Edit driver's status</a><br/><br/><br/>

<p>${message}<br/>
</p>
</body>
