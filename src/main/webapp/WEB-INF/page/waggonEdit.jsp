<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <script src="<c:url value="/resources/js/jQuery.js"/>"></script>
    <script src="<c:url value="/resources/js/editWaggon.js"/>"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Edit waggon page</title>
</head>
<body>
<h1 align="center">Edit waggon page</h1>
<p align="center">Here you can edit existing waggon.</p>
<div align="center">
    <table>
        <tr>
            <td>Registrasion number:</td>
            <td><input id="regNumber"></td>
        </tr>
        <tr>
            <td>Shift size:</td>
            <td><input id="shiftSize"></td>
        </tr>
        <tr>
            <td>Capacity:</td>
            <td><input id="capacity"></td>
        </tr>
        <tr>
            <td>Status:</td>
            <td><select id="waggonStatus">
                <option value="BROKEN">BROKEN</option>
                <option value="WORKING">WORKING</option>
            </select></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><select id="cities">
            </select></td>
        </tr>
            <td><button id="order" onclick="editWaggon()">Edit waggon</button></td>
        </tr>
    </table>
</div>
<p><a href="${pageContext.request.contextPath}/welcome">Home page</a></p>
</body>
</html>