<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" import="org.springbridge.action.Globals"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR PAGE</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/example.css"/>" />
</head>
<c:set var="runtimeException" value="${requestScope[Globals.EXCEPTION_KEY]}"/>
<body>
STRUTS ERROR PAGE 
<pre class="intro">
${runtimeException}
</pre>
<%
if(exception!=null){
	exception.printStackTrace(new java.io.PrintWriter(out));
}
%>
<pre></pre>
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