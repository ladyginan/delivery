<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Edit driver page</title>
</head>
<body>
<h1>Edit driver page</h1>
<p>Here you can edit existing driver.</p>

<form:form method = "POST" modelAttribute="driver" action="${pageContext.request.contextPath}/drivers/edit/${driver.idDriver}.html">
<table>
    <tbody>
    <tr>
        <td>name:</td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td>second Name:</td>
        <td><form:input path="secondName"/></td>
    </tr>
    <tr>
        <td>hours Worked:</td>
        <td><form:input path="hoursWorked"/></td>
    </tr>
    <tr>
        <td>status:</td>
        <td><form:input path="status"/></td>
    </tr>
    <tr>
        <td>current City:</td>
        <td><form:input path="currentCity"/></td>
    </tr>
    <tr>
        <td>current Waggon:</td>
        <td><form:input path="currentWaggon"/></td>
    </tr>

    </tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/welcome.html">Home page</a></p>
</body>
</html>