<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-reboot.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Driver Info</title>
</head>
<body>
<table border="1px" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th width="10%">driver id</th>
        <th width="10%">companions</th>
        <th width="10%">waggon's registrasion number</th>
        <th width="10%">order number</th>
        <th width="10%">list of waypoints</th>
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

    <div>
        <select id = driverShiftStatus>

        </select>
    </div>

    <div>
        <select id="driverStatus">
            <option value="DRIVING">DRIVING</option>
            <option value="SHIFT">SHIFT</option>
            <option value="REST">REST</option>
        </select>
    </div>
    <div>
        <select id="orderCargo">
            <option value="PREPARED">PREPARED</option>
            <option value="SHIPPED">SHIPPED</option>
            <option value="DONE">DONE</option>
        </select>
    </div>

    </tbody>
</table>
</body>
</html>