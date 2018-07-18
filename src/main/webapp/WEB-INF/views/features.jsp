<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

features


<c:forEach items="${element}" var="tes">

<c:forEach items="${tes}" var="single">
<h4>${single}</h4>

</c:forEach>
<h1>----------</h1>
</c:forEach>







