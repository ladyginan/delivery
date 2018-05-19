<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New or Edit driver</title>
</head>
<body>
<div align="center">
    <h1>New cargo</h1>
    <table>
        <form:form action="${pageContext.request.contextPath}/cargoes/add" method="post" modelAttribute="cargo">
            <tr>
                <td>name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>weight:</td>
                <td><form:input path="weight"/>  kg.</td>
            </tr>
            <tr>
                <td>status:</td>
                <td><form:select path="status">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${CargoStatus}" />
                </form:select></td>
            </tr>
        </form:form>
    </table>
</div>
<p><a href="${pageContext.request.contextPath}/">Home page</a></p>
</body>
</html>