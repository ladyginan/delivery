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
        <form:form action="${pageContext.request.contextPath}/orders/add" method="post" modelAttribute="order">
            <tr>
                <td>Done:</td>
                <td><form:select class="form-control" id="order_status" path="status">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${status}" />
                </form:select>
                </td>
            </tr>

            <tr>
                <td>Drivers:</td>
                <td><form:select class="form-control" id="order_drivers" path="drivers">
                    <form:options items="${drivers}" itemValue="idDriver" itemLabel="personalNumber" />
                </form:select>
                </td>
            </tr>
            <tr>
                <td>Waggons:</td>
                <td><form:select class="form-control" id="order_waggons" path="waggons">
                    <form:options items="${waggons}" itemValue="idWaggon" itemLabel="regNumber" />
                </form:select>
                </td>
            </tr>

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            <tr><td>Way Point:</td>
                <td><form:select class="form-control" id="order_waypoints" path= "pointList">
                <form:options items="${wayPoints}" itemValue="idWayPoint" itemLabel="city.city" />
            </form:select> </td>
                <td><form:select class="form-control" id="order_waypoints" path= "pointList">
                    <form:options items="${wayPoints}" itemValue="idWayPoint" itemLabel="city.city" />
                </form:select> </td>
                <td><form:select class="form-control" id="order_waypoints" path= "pointList">
                    <form:options items="${wayPoints}" itemValue="idWayPoint" itemLabel="city.city" />
                </form:select> </td>
            </tr>
            <table border="1px" cellpadding="0" cellspacing="0">
                <thead>
                <tr>
                    <th width="15%">City:</th>
                    <th width="15%">Cargo: </th>
                    <th width="15%">Type:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="wayPoint" items="${wayPoints}">
                    <tr>
                        <td>${wayPoint.city}</td>
                        <td>${wayPoint.cargo}</td>
                        <td>${wayPoint.orderType}</td>

                        <td>
                            <input type = "checkbox" id="way Point" value ="idCity">
                            <label for="way Point">add</label>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

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

</body>
</html>
