<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New or Edit waggon</title>
</head>
<body>
<div align="center">
    <h1>New/Edit waggon</h1>
    <table>
        <form:form action="${pageContext.request.contextPath}/waggons/add" method ="post" modelAttribute="waggon">
            <tr>
                <td>Shift size:</td>
                <td><form:input path="shiftSize"/></td>
            </tr>
            <tr>
                <td>Capacity:</td>
                <td><form:input path="capacity"/></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td>
                    <form:select path="status">
                        <form:option value="" label ="Please select"/>
                        <form:options itmes="${statusWaggon}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Current city:</td>
                <td><form:input path="currentCity"/></td>
            </tr>

        </form:form>
    </table>

</div>
</body>
</html>