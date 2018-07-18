<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

test details




<c:forEach items="${testList1}" var="test">
<c:forEach items="${test}" var="single">
<a href="<spring:url value="/testdetails/${single}.html"/>">
			<h4>${single}</h4>
			</a>


</c:forEach>
<h1>----------</h1>
</c:forEach>


<c:forEach items="${methodlist}" var="test">
<c:forEach items="${test}" var="single">
<h4>${single}</h4>

</c:forEach>
<h1>----------</h1>
</c:forEach>





