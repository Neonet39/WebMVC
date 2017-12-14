<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<jsp:include page="cap.jsp"/>
<br>
<br>
<div class="container">
    <div class="starter-template">
        <form name="form-login" action="/login" method="post">
             user:<br>
            <input type="text" id="username" name="username"/><br><br>
             password:<br>
            <input type="password" id="password" name="password"/><br><br>
            <button type="submit" class="btn">Log in</button>
        </form>
    </div>
</div>

</body>
</html>
