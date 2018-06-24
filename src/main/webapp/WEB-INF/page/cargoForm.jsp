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
    <title>Cargo create</title>
</head>
<body>
<h1>New cargo</h1>
<div class = "d-flex flex-row justify-content-center">
    <br/>
    <div>
        <form:form action="${pageContext.request.contextPath}/cargoes/add" method="post" modelAttribute="cargo">
            <div>
                <label>Сargo registration number:</label>
                <form:input path="cargoNumber" class="form-control"/>
            </div>
            <div>
                <label>Name:</label>
                <form:input path="name" class="form-control"/>
            </div>
            <div>
                <label>Weight(kg):</label>
                <form:input path="weight" class="form-control"/>
            </div>
            <div>
                <label>Status:</label>
                <form:select class="form-control" path="status">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${CargoStatus}" />
                </form:select>
            </div>
            <div>
                <div class = "but">
                        <button type="submit" class="btn btn-outline-secondary btn-block">Save</button>
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