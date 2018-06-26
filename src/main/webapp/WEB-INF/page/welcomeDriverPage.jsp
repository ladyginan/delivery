<%--
  Created by IntelliJ IDEA.
  User: irish
  Date: 06.06.2018
  Time: 1:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="/resources/myCss/form.css">
    <title>Hello!</title>
</head>
<body>
<div class = "d-flex flex-row justify-content-center">
<a class="btn btn-primary btn-lg active" role="button" aria-pressed="true" href="${pageContext.request.contextPath}/driverPage/${driverID}">Info panel here!</a>
</div>
<div class = " message d-flex flex-row justify-content-center" >
    ${message}
</div>
</body>
</html>
