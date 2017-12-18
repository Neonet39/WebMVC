<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<jsp:include page="cap.jsp" />
<br>
<br>
<div class="container">
    <div class="starter-template">
        <form:form method="post" action="/login/authorize" modelAttribute="userLoginForm" >
             user:<br>
            <form:input path="login"/><br><br>
             password:<br>
            <form:input path="password"/><br><br>
            <input type="submit" value="Submit"/>
        </form:form>
    </div>
</div>

</body>
</html>
