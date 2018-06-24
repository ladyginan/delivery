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
    <title>New waggon</title>
</head>
<body>
<h1>New waggon</h1>
<div class = "d-flex flex-row justify-content-center">
    <br/>
    <div>
        <form:form action="${pageContext.request.contextPath}/waggons/add" method ="post" modelAttribute="waggon">
            <div class="form-group">
                <label for="forNumb" placeholder="Example:XX12345">Registration Number:</label>
                <form:input path="regNumber" id="forNumb" class="form-control"/>
            </div>
            <div>
                <label for="forSize">Shift size:</label>
                <form:input path="shiftSize" id="forSize" class="form-control"/>
            </div>
            <div>
                <label for="forCap">Capacity(tons):</label>
                <form:input path="capacity" id="forCap" class="form-control"/>
            </div>
            <div>
                <label for="forStatus">Status:</label>
                    <form:select class="form-control" path="status" id="forStatus">
                        <form:option value="" label ="Please select"/>
                        <form:options items="${statusWaggon}"/>
                    </form:select>
            </div>
            <div>
                <label for="forCity">Current city:</label>
                    <form:select class="form-control" path="city" id="forCity">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${maps}" itemValue="idCity" itemLabel="city" />
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