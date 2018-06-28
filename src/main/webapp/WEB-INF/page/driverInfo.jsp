<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <script src="<c:url value="/resources/js/jQuery.js"/>"></script>
    <script src="<c:url value="/resources/js/driverInfo.js"/>"></script>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="/resources/myCss/form.css">
    <title>Driver Info</title>
</head>
<body>
<div>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">personal number</th>
        <th scope="col">waggon's registration number</th>
        <th scope="col">order number</th>
        <th scope="col">companions</th>
        <th scope="col">list of waypoints</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td scope="row"><p id = "personalNumber"></p></td>
            <td><p id = "waggonRegNumber"></p></td>
            <td><p id = "orderNumber"></p></td>
            <td id = "companions"></td>
            <td id = "wayPoints"></td>
        </tr>
    </tbody>
</table>
</div>
    <br/>
        <%--<tr><td>Start/End working:</td>--%>
            <%--<td><select id = driverShiftStatus>--%>
                <%--<option value="START">START</option>--%>
                <%--<option value="END">END</option>--%>
            <%--</select>--%>
            <%--</td>--%>
        <%--</tr>--%>
<div class = "d-flex flex-row justify-content-center">
<div>
    <div class="form-group">
            <label for ="driverShiftStatus">Driver status:</label>
            <select id="driverShiftStatus" class="form-control">
                 <option value="DRIVING">DRIVING</option>
                <option value="SHIFT">SHIFT</option>
                <option value="REST">REST</option>
            </select>
    </div>
    <div>
            <label for ="orderCargo">Cargo status:</label>
             <select id="orderCargo" class="form-control">
                <option value="PREPARED">PREPARED</option>
                 <option value="SHIPPED">SHIPPED</option>
                <option value="DONE">DONE</option>
            </select>
    </div>

            <div class = "but"><button id="driverSave" class="btn btn-outline-secondary btn-block" onclick="saveChangeDriver()">Save</button></div>

        <div class="message">
            ${message}
        </div>
</div>
</div>
    <div class = "d-flex flex-row justify-content-center">  <form action="/logout" method="post">
        <input value="Logout" type="submit">
    </form></div>
</body>
</html>