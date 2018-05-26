<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Edit driver page</title>
</head>
<body>
<h1>Edit driver page</h1>
<p>Here you can edit existing driver.</p>

<form:form method = "POST" modelAttribute="driverDTO" action="${pageContext.request.contextPath}/drivers/edit/${driver.idDriver}.html">
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
        <td>personal number:</td>
        <td><form:input path="personalNumber"/></td>
    </tr>
    <tr>
        <td>hours Worked:</td>
        <td><form:input path="hoursWorked"/></td>
    </tr>
    <tr>
        <td>status:</td>
        <td><form:select class="form-control" path="status">
            <form:option value="" label="${driverDTO.status}"/>
            <form:options items="${DriverStatus}" />
        </form:select>
        </td>
    </tr>
    <tr>
        <td>current City:</td>
        <td>
            <form:select class="form-control" id ="idCity" path="city">
                <form:option value="" label="${driverDTO.city.city}"/>
                <form:options items="${maps}" itemValue="idCity" itemLabel="city" />
            </form:select></td>
    </tr>
    <tr>
        <td>current Waggon:</td>
        <td><form:select class="form-control" path="waggon">
            <form:option value="" label="${driverDTO.waggon.regNumber}"/>
            <form:options items="${waggons}" itemValue="IdWaggon" itemLabel="regNumber" />
        </form:select></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Save">
        </td>
    </tr>

    </tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/welcome">Home page</a></p>
</body>
</html>