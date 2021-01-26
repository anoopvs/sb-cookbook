<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" import="org.springbridge.action.Globals"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ActionRedirect Chain Complete</title>
</head>
<body>
<div class="result">
	<p class="h5">ActionRedirect chain Completed !!!</p>
	<c:forEach var="paramValue" items='<%=request.getParameterValues("action")%>'>
		<p class="h5">${paramValue}</p>
	</c:forEach> 
	<c:forEach var="paramValue" items='<%=request.getParameterValues("id")%>'>
		<p class="h5">${paramValue}</p>
	</c:forEach> 
</div>
</body>
</html>