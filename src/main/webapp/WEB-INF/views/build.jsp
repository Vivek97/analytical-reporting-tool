<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

build


<c:forEach items="${suiteList}" var="suite">
<c:forEach items="${suite}" var="single">
<a href="<spring:url value="/build/${single}.html"/>">
			<h4>${single}</h4>
			</a>

<%-- <h4>${single}</h4> --%>

</c:forEach>
<h1>next</h1>
</c:forEach>







