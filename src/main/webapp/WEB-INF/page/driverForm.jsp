<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New driver</title>
</head>
<body>
<div align="center">
    <h1>New driver</h1>
    <table >
        <form:form action="${pageContext.request.contextPath}/drivers/add" method="post" modelAttribute="driver">
           <tr>
                <td>name:</td>
                <td><form:input  path="name"/></td>
            </tr>
            <tr>
                <td>second name:</td>
                <td><form:input  path="secondName"/></td>
            </tr>
            <tr>
                <td>personal number:  </td>
                <td><form:input  path="personalNumber"/></td>
            </tr>
            <tr>
                <td>hours worked:</td>
                <td><form:input path="hoursWorked"/></td>
            </tr>
            <tr>
                <td>status:</td>
                <td><form:select class="form-control" path="status">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${statusDriver}" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>current city:</td>
                <td>
                <form:select class="form-control" path="city">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${maps}" itemValue="idCity" itemLabel="city" />
                </form:select></td>
            </tr>
            <tr>
                <td>current waggon:</td>
                <td><form:select class="form-control" path="waggon">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${waggons}" itemValue="IdWaggon" itemLabel="IdWaggon" />
                    </form:select></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </form:form>
    </table>
</div>
<p><a href="${pageContext.request.contextPath}/">Home page</a></p>
</body>
</html>