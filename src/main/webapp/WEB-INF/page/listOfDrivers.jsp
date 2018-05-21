<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/form.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>List of drivers</title>
</head>
<body>
<h1>List of drivers</h1>
<p>Here you can see the list of drivers,remove or update them.</p>

<table border="1px" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th width="10%">name</th>
        <th width="10%">second name</th>
        <th width="10%">hours worked</th>
        <th width="10%">status</th>
        <th width="10%">current city</th>
        <th width="10%">current waggon</th>
        <th width="10%">action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="driver" items="${drivers}">
            <tr>
                <td>${driver.name}</td>
                <td>${driver.secondName}</td>
                <td>${driver.hoursWorked}</td>
                <td>${driver.status}</td>
                <td>${driver.city.city}</td>
                <td>${driver.waggon.regNumber}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/drivers/edit/${driver.idDriver}.html">Edit</a><br/>
                    <a href="${pageContext.request.contextPath}/drivers/delete/${driver.idDriver}.html">Delete</a><br/>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/">Home page</a></p>

</body>
</html>