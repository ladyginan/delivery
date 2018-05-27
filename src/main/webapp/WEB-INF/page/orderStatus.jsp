<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Orders status</title>
</head>
<body>
<h1>Order status</h1>
<p>Here you can see status of order.
<table border="1px" cellpadding="0" cellspacing="0">
    <thread>
        <tr>
            <th width="10%">Registration number</th>
            <th width="10%">Status</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach var = "order" items="${orders}">
        <tr>
            <td>${order.regNumberOrder}</td>
            <td>${order.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/welcome">Home page</a></p>
</body>
</html>