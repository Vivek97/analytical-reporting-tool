<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>

testng dashboard
<h1>Stable</h1>

<c:forEach items="${stable}" var="tes">

<c:forEach items="${tes}" var="single">
<h4>${single}</h4>

</c:forEach>
<h1>----------</h1>
</c:forEach>

<c:forEach items="${projectTotal}" var="single">
<h4>${single}</h4>

</c:forEach>
<h1>--------------<h1>UnStable</h1>------------</h1>
<c:forEach items="${unstable}" var="tes">

<c:forEach items="${tes}" var="single">
<h4>${single}</h4>

</c:forEach>
<h1>----------</h1>
</c:forEach>

<h1>---------------<h1>Skipped</h1>-----------</h1>
<c:forEach items="${skipped}" var="tes">

<c:forEach items="${tes}" var="single">
<h4>${single}</h4>

</c:forEach>
<h1>----------</h1>
</c:forEach>

<h1>--------------<h1>Duration</h1>------------</h1>
<c:forEach items="${duration}" var="tes">

<c:forEach items="${tes}" var="single">
<h4>${single}</h4>

</c:forEach>
<h1>----------</h1>
</c:forEach>