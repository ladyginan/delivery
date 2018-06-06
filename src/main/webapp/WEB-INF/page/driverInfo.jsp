<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
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
        <th width="20%">driver id</th>
        <th width="20%">companions</th>
        <th width="18%">waggon's registrasion number</th>
        <th width="20%">order number</th>
        <th width="20%">list of waypoints</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td id = "idDriver"></td>
            <td id = "waggonRegNumber"></td>
            <td id = "orderNumber"></td>
            <td id = "companions"></td>
            <td id = "wayPoints"></td>
        </tr>
    </tbody>
</table>
    <br/>
    <br/>
    <br/>

    <table>
        <tr>
            <select id = driverShiftStatus>

            </select>
        </tr>

        <tr>
            <td>Driver status:</td>
            <td>  <select id="driverStatus">
                 <option value="DRIVING">DRIVING</option>
                <option value="SHIFT">SHIFT</option>
                <option value="REST">REST</option>
            </select></td>
        </tr>
        <tr><td>Cargo status:</td>
            <td>   <select id="orderCargo">
                <option value="PREPARED">PREPARED</option>
                 <option value="SHIPPED">SHIPPED</option>
                <option value="DONE">DONE</option>
            </select></td>
        </tr>
        <tr>
            <td><button id="order" onclick="saveChangeDriver()">Save</button></td>
        </tr>
    </table>

</div>
</body>
</html>