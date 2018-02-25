<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Music Theory Trainer</title>
</head>
<body onload="document.f.username.focus();">
     <h1>Welcome to Music Theory Trainer</h1>
     <form:form name="f" method="post">
         <div>
            <label for="username">Username:</label>
            <input type="text" name="username" id="username">
         </div>
         <div>
             <label for="password">Password:</label>
             <input type="password" name="password" id="password">
         </div>
         <div>
             <input id="remember_me" name="remember-me" type="checkbox" value="Remember me">
         </div>
         <div>
             <input name="submit" type="submit" value="Login">
         </div>
     </form:form>
</body>
</html>
