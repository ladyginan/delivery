<%--
  Created by IntelliJ IDEA.
  User: irish
  Date: 02.06.2018
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">Select your profile</h1>
<p align="center">Here you can select your profile</p>
<div align="center">
    <table>
        <tr>
            <td>
                <select id="drivers">
                </select>
            </td>
        </tr>
        <tr>
            <td><button id="userDriver" onclick="createDriverUser()">Select driver</button></td>
        </tr>
    </table>
    <form action="/logout" method="post">
        <input value="Logout" type="submit">
    </form>
</div>
</body>
</html>
