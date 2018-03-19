<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form name="f" method="post">
        <div>
            You guessed <c:out value="${guess}" /> and the answer was <c:out value="${answer}" />
        </div>
        <div>
            <input name="submit" type="submit" value="Next">
        </div>
    </form:form>
</body>
</html>
