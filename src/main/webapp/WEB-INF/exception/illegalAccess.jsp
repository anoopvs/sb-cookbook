<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" import="org.springbridge.action.Globals"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IllegalAccess Exception</title>
</head>
<body>
<c:set var="sbException" value="${requestScope['org.springbridge.action.EXCEPTION']}"/>
###${sbException}###
<%
Exception rtExc=(Exception)request.getAttribute(Globals.EXCEPTION_KEY);
if(rtExc!=null){
	rtExc.printStackTrace(new java.io.PrintWriter(out));
}
%>
<div class="error">
springbridge_exception_guid ${springbridge_exception_guid} <br/>
status_code : <%=request.getAttribute("javax.servlet.error.status_code") %><br/>
exception_type :<%=request.getAttribute("javax.servlet.error.exception_type") %><br/>
message :<%=request.getAttribute("javax.servlet.error.message") %><br/>
exception :<%=request.getAttribute("javax.servlet.error.exception") %><br/>
request_uri :<%=request.getAttribute("javax.servlet.error.request_uri") %><br/>
servlet_name :<%=request.getAttribute("javax.servlet.error.servlet_name") %><br/>
</div>
</body>
</html>