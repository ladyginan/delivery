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
    <title>Driver Info</title>
</head>
<body>
<div>
<table border="1px" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th width="20%">personal number</th>
        <th width="18%">waggon's registrasion number</th>
        <th width="20%">order number</th>
        <th width="20%">companions</th>
        <th width="20%">list of waypoints</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td><p id = "personalNumber"></p></td>
            <td><p id = "waggonRegNumber"></p></td>
            <td><p id = "orderNumber"></p></td>
            <td id = "companions"></td>
            <td id = "wayPoints"></td>
        </tr>
    </tbody>
</table>
    <br/>
    <br/>
    <br/>

    <table>
        <%--<tr><td>Start/End working:</td>--%>
            <%--<td><select id = driverShiftStatus>--%>
                <%--<option value="START">START</option>--%>
                <%--<option value="END">END</option>--%>
            <%--</select>--%>
            <%--</td>--%>
        <%--</tr>--%>

        <tr>
            <td>Driver status:</td>
            <td>  <select id="driverShiftStatus">
                 <option value="DRIVING">DRIVING</option>
                <option value="SHIFT">SHIFT</option>
                <option value="REST">REST</option>
            </select></td>
        </tr>
        <tr>
            <td>Cargo status:</td>
            <td>   <select id="orderCargo">
                <option value="PREPARED">PREPARED</option>
                 <option value="SHIPPED">SHIPPED</option>
                <option value="DONE">DONE</option>
            </select></td>
        </tr>
        <tr>
            <td><button id="driverSave" onclick="saveChangeDriver()">Save</button></td>
        </tr>
    </table>

</div>
<div class="message">
    ${message}
</div>

<br/><br/><br/>
<form action="/logout" method="post">
    <input value="Logout" type="submit">
</form>
</body>
</html>