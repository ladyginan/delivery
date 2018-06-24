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
    <link rel="stylesheet" href="/resources/myCss/form.css">
    <title>Title</title>
</head>
<body>
<h1>New order</h1>
<div class = "d-flex flex-row justify-content-center">
    <div>
            <div>
                <label>Registration number of order:</label>
                <input id="regNumberOrder" class="form-control">
            </div>

            <div>
                <label>Order status:</label>
                <select id="orderStatus" class="form-control">
                    <option value="COMPLETED">COMPLETED</option>
                    <option value="NOTCOMPLETED">NOT COMPLETED</option>
                </select>
            </div>

            <div>
                <label>Way points:</label>
                <select id="waypoints" multiple="multiple" class="form-control">
                </select>
            </div>

            <div>
                <label>Drivers:</label>
                <select id="drivers" multiple="multiple" class="form-control">
                </select>
            </div>

            <div>
                <label>Waggons:</label>
                <select id="waggons" class="form-control">
                </select>
            </div>
            <div>
                <div class="but"><button id="order" class="btn btn-outline-secondary btn-block" onclick="createOrder()">Create order</button></div>
            </div>



    </div>
</div>
<nav class="navbar fixed-bottom navbar-light bg-light">
    <a class="navbar-b" href="${pageContext.request.contextPath}/">Home page</a>
</nav>
</body>
</html>
