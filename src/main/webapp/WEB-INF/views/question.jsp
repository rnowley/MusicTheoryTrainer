<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="questionDiv">
        <c:out value="${question}" />
    </div>
    <form:form name="answerForm" method="post">
        <div id="answerDiv">
            <div>
                <input type="radio" id="cflat"
                       name="guess" value="1">
                <label for="cflat">Cb</label>

                <input type="radio" id="c"
                       name="guess" value="2">
                <label for="c">C</label>

                <input type="radio" id="csharp"
                       name="guess" value="3">
                <label for="csharp">C#</label>
                <input type="radio" id="dflat"
                       name="guess" value="4">
                <label for="cflat">Db</label>

                <input type="radio" id="d"
                       name="guess" value="5">
                <label for="d">D</label>

                <input type="radio" id="sharp"
                       name="guess" value="6">
                <label for="csharp">D#</label>
            </div>
            <div>
                <input type="radio" id="eflat"
                       name="guess" value="7">
                <label for="eflat">Eb</label>

                <input type="radio" id="e"
                       name="guess" value="8">
                <label for="e">E</label>

                <input type="radio" id="esharp"
                       name="guess" value="9">
                <label for="esharp">E#</label>
                <input type="radio" id="fflat"
                       name="guess" value="10">
                <label for="fflat">Fb</label>

                <input type="radio" id="f"
                       name="guess" value="11">
                <label for="f">F</label>

                <input type="radio" id="fsharp"
                       name="guess" value="12">
                <label for="fsharp">F#</label>
            </div>
        </div>
        <div>
            <input name="submit" type="submit" value="Submit">
        </div>
    </form:form>

</body>
</html>
