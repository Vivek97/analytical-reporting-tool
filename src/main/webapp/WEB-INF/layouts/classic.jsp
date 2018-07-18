<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

 
<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


 <%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
 <tilesx:useAttribute name="current"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"/></title>
</head>
<body>

 <div class="container">

      <!-- Static navbar -->
      <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/"/>'>HIMANSHU</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
           	 
           	  <security:authorize access="hasRole('ROLE_VERIZON')">
           	  <li class="${current == 'testngdashboard' ? 'active' : ''}"><a href='<spring:url value="/testngdashboard.html"/>'>VERIZON DASHBOARD</a></li>
              <li class="${current == 'build' ? 'active' : ''}"><a href='<spring:url value="/build.html"/>'>BUILD SUMMARY</a></li>
              <li class="${current == 'testngbuild' ? 'active' : ''}"><a href='<spring:url value="/testngbuild.html"/>'>BUILD ANALYSIS</a></li>
              </security:authorize>
              <security:authorize access="hasRole('ROLE_PUMA')">
           	  <li class="${current == 'jsondashboard' ? 'active' : ''}"><a href='<spring:url value="/jsondashboard.html"/>'>PUMA DASHBOARD</a></li>
               <li class="${current == 'features' ? 'active' : ''}"><a href='<spring:url value="/features.html"/>'>BUILD SUMMARY</a></li>
              <li class="${current == 'jsonbuild' ? 'active' : ''}"><a href='<spring:url value="/jsonbuild.html"/>'>BUILD ANALYSIS</a></li>
              </security:authorize>
              <security:authorize access="hasRole('ROLE_ADMIN')">
              <li class="${current == 'users' ? 'active' : ''}"><a href="<spring:url value="/users.html"/>">USERS</a></li>
              </security:authorize>
              <security:authorize access="! isAuthenticated()">
              <li class="${current == 'register' ? 'active' : ''}"><a href="<spring:url value="/register.html"/>">REGISTRATION</a></li>
              <li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login.html"/>">LOGIN</a></li>
              </security:authorize>
              <security:authorize access="isAuthenticated()">
              <li><a href="<spring:url value="/logout"/>">LOGOUT</a></li>
              </security:authorize>
             </ul>
  
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>

<tiles:insertAttribute name="body"/>


<br><br>

<center>
<tiles:insertAttribute name="footer" />
</center>

</div>
</body>
</html>