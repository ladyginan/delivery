<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New way point</title>
</head>
<body>
<div align="center">
    <h1>New driver</h1>
    <table>
        <form:form action="${pageContext.request.contextPath}/points/add" method="post" modelAttribute="wayPoint">
            <tr>
                <td>city:</td>
                <td>
                    <form:select id ="idCity" path="city">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${cities}" itemValue="idCity" itemLabel="city" />
                    </form:select>
                </td>
            </tr>
            <tr><td>cargo ID:</td>
                <td>
                    <form:select id ="idCargo" path="cargo">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${cargoes}" itemValue="idCargo" itemLabel="cargoNumber" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>type:</td>
                <td><form:select path="orderType">
                    <form:option value="" label=" Please select"/>
                    <form:options items="${OrderType}"/>
                </form:select>
                </td>
            </tr>

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