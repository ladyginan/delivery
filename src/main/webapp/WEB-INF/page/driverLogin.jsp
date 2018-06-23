<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="<c:url value="/resources/js/jQuery.js"/>"></script>
    <script src="<c:url value="/resources/js/selectDriverUser.js"/>"></script>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-reboot.min.css">
    <title>Title</title>
</head>
<body>
<h1 align="center">Select your profile</h1>
<p align="center">Here you can select your profile</p>
<div align="center">
    <table>
        <tr>
            <td>
                <select id="drivers">
                </select>
            </td>
        </tr>
        <tr>
            <td><button id="userDriver" onclick="createDriverUser()">Select driver</button></td>
        </tr>
    </table><br/><br/><br/>
    <form action="/logout" method="post">
        <input value="Logout" type="submit">
    </form>
</div>
</body>
</html>
