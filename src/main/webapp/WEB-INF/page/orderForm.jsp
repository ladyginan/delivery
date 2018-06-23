<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script src="<c:url value="/resources/js/jQuery.js"/>"></script>
    <script src="<c:url value="/resources/js/ajax.js"/>"></script>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-reboot.min.css">
    <title>Title</title>
</head>
<body>

<div align="center">
    <h1>New order</h1>
    <table>
            <tr>
                <td>Registration number of order:</td>
                <td><input id="regNumberOrder"></td>
            </tr>

            <tr>
                <td>Order status number:</td>
                <td><select id="orderStatus">
                    <option value="COMPLETED">COMPLETED</option>
                    <option value="NOTCOMPLETED">NOTCOMPLETED</option>
                </select></td>
            </tr>

            <tr>
                <td>Way points:</td>
                <td><select id="waypoints" multiple="multiple">
                </select></td>
            </tr>

            <tr>
                <td>Drivers:</td>
                <td><select id="drivers" multiple="multiple">
                </select></td>
            </tr>

            <tr>
                <td>Waggons:</td>
                <td><select id="waggons">
                </select></td>
            </tr>

            <tr>
                <td><button id="order" onclick="createOrder()">Create order</button></td>
            </tr>


    </table>
</div>
<p><a href="${pageContext.request.contextPath}/">Home page</a></p>
</body>
</html>
