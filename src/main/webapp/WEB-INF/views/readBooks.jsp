<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="cap.jsp" />

<div class="container">
    <div class="starter-template">
        <h3>${books.title}</h3>
        <p>${books.content}</p>
        <a href="/mainPage"><spring:message code="link_home"/></a>
    </div>
</div>
</body>
</html>
