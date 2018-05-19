<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Edit waggon page</title>
</head>
<body>
<h1>Edit waggon page</h1>
<p>Here you can edit existing waggon.</p>

<form:form method = "POST" modelAttribute="waggon" action="${pageContext.request.contextPath}/waggons/edit/${waggon.idDriver}.html">
    <table>
        <tbody>
        <tr>
            <td>Capacity:</td>
            <td><form:input path="regNumber"/></td>
        </tr>
        <tr>
            <td>Shift size:</td>
            <td><form:input path="shiftSize"/></td>
        </tr>
        <tr>
            <td>Capacity:</td>
            <td><form:input path="capacity"/></td>
        </tr>
        <tr>
            <td>Status:</td>
            <td>
                <form:select path="status">
                    <form:option value="" label ="Please select"/>
                    <form:options itmes="${statusWaggon}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Current city:</td>
            <td><form:input path="currentCity"/></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/welcome.html">Home page</a></p>
</body>
</html>