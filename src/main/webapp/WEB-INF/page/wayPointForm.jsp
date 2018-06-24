<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="/resources/myCss/form.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New way point</title>
</head>
<body>
<h1>New way point</h1>
<div class = "d-flex flex-row justify-content-center">
    <div>
        <form:form action="${pageContext.request.contextPath}/points/add" method="post" modelAttribute="wayPoint">
            <div>
                <label>City:</label>
                    <form:select class="form-control" id ="idCity" path="city">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${cities}" itemValue="idCity" itemLabel="city" />
                    </form:select>

            </div>
            <div><label>Сargo registration number:</label>
                    <form:select class="form-control" id ="idCargo" path="cargo">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${cargoes}" itemValue="idCargo" itemLabel="cargoNumber" />
                    </form:select>
            </div>
            <div>
                <label>Type:</label>
                <form:select class="form-control" path="orderType">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${OrderType}"/>
                </form:select>
            </div>

            <div>
                <div class = "but"> <button type="submit" class="btn btn-outline-secondary btn-block">Save</button>
                </div>
            </div>
        </form:form>
    </div>
</div>
<nav class="navbar fixed-bottom navbar-light bg-light">
    <a class="navbar-b" href="${pageContext.request.contextPath}/">Home page</a>
</nav>
</body>
</html>