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
    <link rel="stylesheet" href="/resources/myCss/table.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>List of waggons</title>
</head>
<body>
<h1>List of waggons</h1>
<p>Here you can see the list of waggons,remove or update them.</p>

<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">registration Number</th>
            <th scope="col">shift size</th>
            <th scope="col">capacity</th>
            <th scope="col">status</th>
            <th scope="col">current city</th>
            <th scope="col">action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var = "waggon" items = "${waggons}">
            <tr>
                <td scope="row">${waggon.regNumber}</td>
                <td>${waggon.shiftSize}</td>
                <td>${waggon.capacity}</td>
                <td>${waggon.status}</td>
                <td>${waggon.city.city}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/waggons/edit/${waggon.idWaggon}.html">Edit</a><br/>
                    <a href="${pageContext.request.contextPath}/waggons/delete/${waggon.idWaggon}.html">delete</a><br/>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/">Home page</a></p>

</body>
</html>