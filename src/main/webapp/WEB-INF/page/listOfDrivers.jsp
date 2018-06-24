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
    <title>List of drivers</title>
</head>
<body>
<h1>List of drivers</h1>
<p>Here you can see the list of drivers,remove or update them.</p>

<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">personal number</th>
            <th scope="col">name</th>
            <th scope="col">second name</th>
            <th scope="col">hours worked</th>
            <th scope="col">status</th>
            <th scope="col">current city</th>
            <th scope="col">current waggon</th>
            <th scope="col">action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var = "driver" items = "${drivers}">
            <tr>
                <td scope="row">${driver.personalNumber}</td>
                <td>${driver.name}</td>
                <td>${driver.secondName}</td>
                <td>${driver.hoursWorked}</td>
                <td>${driver.status}</td>
                <td>${driver.city.city}</td>
                <td>${driver.waggon.regNumber}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/drivers/edit/${driver.idDriver}">Edit</a><br/>
                    <a href="${pageContext.request.contextPath}/drivers/delete/${driver.idDriver}">Delete</a><br/>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/">Home page</a></p>

</body>
</html>