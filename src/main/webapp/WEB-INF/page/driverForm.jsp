<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New or Edit Driver</title>
</head>
<body>
<div align="center">
    <h1>New/Edit Driver</h1>
    <table>
        <form:form action="${pageContext.request.contextPath}/drivers/add" method="post" modelAttribute="driver">
            <tr>
                <td>driver id:</td>
                <td><form:input path="idDriver"/></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>second name:</td>
                <td><form:input path="secondName"/></td>
            </tr>
            <tr>
                <td>hours worked:</td>
                <td><form:input path="hoursWorked"/></td>
            </tr>
            <tr>
                <td>status:</td>
                <td><form:input path="status"/></td>
            </tr>
            <tr>
                <td>current city:</td>
                <td><form:input path="currentCity"/></td>
            </tr>
            <tr>
                <td>current waggon:</td>
                <td><form:input path="currentWaggon"/></td>
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