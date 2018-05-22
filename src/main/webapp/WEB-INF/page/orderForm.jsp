<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="<c:url value="/resources/js/jQuery.js"/>"></script>
    <script src="<c:url value="/resources/js/ajax.js"/>"></script>

    <title>Title</title>
</head>
<body>

<textarea id="data" style="width: max-content">

</textarea>

<button id="load-ajax" onclick="loadMaps()">Load data to text area</button>

</body>
</html>
