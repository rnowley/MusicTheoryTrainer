<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Theory Trainer</title>
</head>
<body>
    <h1>Note Identification Exercise</h1>
    <p>Please press start to start the exercise.</p>
    <form:form name="f" method="post">
        <div>
            <input name="submit" type="submit" value="Start">
        </div>
    </form:form>
</body>
</html>