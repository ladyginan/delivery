<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Order</title>
</head>
<body>
<div align="center">
    <h1>New order</h1>
    <table>
        <form:form action="${pageContext.request.contextPath}/orders/add" method="post" modelAttribute="order">
            <tr>
                <td>Done:</td>
                <td><form:select path="status">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${status}" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Start Point:</td>
                <td><form:select path= "wayPoint">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${wayPoints}" itemValue="idWayPoint" itemLabel="city.city" />
                </form:select>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>End Point:</td>--%>
                <%--<td><form:select path="wayPointEnd">--%>
                    <%--<form:option value="" label=" Please select"/>--%>
                    <%--<form:options items="${wayPointEnd}" />--%>
                <%--</form:select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td>Waggon:</td>
                <td><form:select path="currentWaggon">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${waggons}" />
                </form:select>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>Driver 1:</td>--%>
                <%--<td><form:select path="driverFirst">--%>
                    <%--<form:option value="" label=" Please select"/>--%>
                    <%--<form:options items="${driverFirst"}" />--%>
                <%--</form:select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Driver 2:</td>--%>
                <%--<td><form:select path="driverSecond">--%>
                    <%--<form:option value="" label=" Please select"/>--%>
                    <%--<form:options items="${driverSecond}" />--%>
                <%--</form:select>--%>
                <%--</td>--%>
            <%--</tr>--%>

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

</div>