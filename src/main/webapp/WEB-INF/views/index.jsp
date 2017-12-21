<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<jsp:include page="cap.jsp" />

<div class="container">
    <div class="starter-template">

        <h3><spring:message code="choose"/></h3>
        <c:forEach var="books" items="${booksList}">
            ${books.title}<br>
            ${books.description}<br>
            <a href="/getBook?id=${books.id}"><spring:message code="read"/></a>
            <br>
            <br>
        </c:forEach>
    </div>
</div>
</body>
</html>
