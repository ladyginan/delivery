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
    <title>New driver</title>
</head>
<body>
<h1>New driver</h1>
<div class = "d-flex flex-row justify-content-center">
    <br/>
        <form:form action="${pageContext.request.contextPath}/drivers/add" method="post" modelAttribute="driver">
            <div class="form-group">
                <label for="formName">Name</label>
                <form:input  path="name" class="form-control" id = "formName"/>
                <form:errors path="name" cssClass="error" />
           </div>
            <div>
                <label for="formSecName">Second name:</label>
                <form:input  path="secondName" class="form-control" id = "formSecName"/>
                <form:errors path="secondName" cssClass="error" />
            </div>
            <div>
                <label for="formNumb">Personal number: </label>
                <form:input  path="personalNumber" class="form-control" id ="formNumb"/>
                <form:errors path="personalNumber" cssClass="error" />
            </div>
            <div>
                <label for="formHours">Hours worked:</label>
                <form:input path="hoursWorked" class="form-control" id = "formHours"/>
                <form:errors path="hoursWorked" cssClass="error" />
            </div>
            <div>
                <label for="forStatus">Status:</label>
                <form:select class="form-control" path="status" id ="forStatus">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${statusDriver}" />
                </form:select>

                <form:errors path="status" cssClass="error" />
            </div>
            <div>
                <label for="forCity">Current city:</label>
                <form:select class="form-control" path="city" id="forCity">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${maps}" itemValue="idCity" itemLabel="city" />
                </form:select>

              <form:errors path="city" cssClass="error" />
            </div>
            <div>
                <label for="forWaggon">Current waggon:</label>
                <form:select class="form-control" path="waggon" id = "forWaggon">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${waggons}" itemValue="IdWaggon" itemLabel="IdWaggon" />
                    </form:select>

                <form:errors path="waggon" cssClass="error" />
            </div>
            <div>
                <div class = "but"> <button type="submit" class="btn btn-outline-secondary btn-block">Save</button>
                </div>
            </div>
        </form:form>

</div>
<nav class="navbar fixed-bottom navbar-light bg-light">
    <a class="navbar-link" href="${pageContext.request.contextPath}/">Home page</a>
</nav>
<%--<div class = "d-flex justify-content-center home"><a href="${pageContext.request.contextPath}/">Home page</a></div>--%>
</body>
</html>