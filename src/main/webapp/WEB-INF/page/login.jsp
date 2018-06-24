<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <%--<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-grid.min.css">--%>
    <%--<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-reboot.min.css">--%>
    <%--<link rel="stylesheet" href="/resources/bootstrap/js/bootstrap.min.js">--%>
    <%--<link rel="stylesheet" href="/resources/bootstrap/js/bootstrap.bundle.min.js">--%>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Delivery</title>
</head>
<body >
<div  align="center" >

<h4 >Login Form</h4>

<form action='<c:url value="/loginAction"/>' method="post">

    <div   class="form-group">
         <label for="log">Username</label>
        <input class="form-control col-md-3 mb-3" type="text" id = "log" name="username" placeholder="Enter username">
    </div>

    <div  class="form-group">
           <label for="pas">Password</label>
        <input class="form-control col-md-3 mb-3" type="password" id = pas name="password" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>


</form>
<br/>
</div>
</body>
</html>