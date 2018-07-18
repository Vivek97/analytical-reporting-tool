<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

class details




<c:forEach items="${classList}" var="suite">
<c:forEach items="${suite}" var="single">
<h4>${single}</h4>

</c:forEach>
<h1>next</h1>
</c:forEach>



<c:forEach items="${methodlist}" var="test">
<c:forEach items="${test}" var="single">
<h4>${single}</h4>

</c:forEach>
<h1>----------</h1>
</c:forEach>



