<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"
	import="org.springbridge.action.Globals"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="result">
Welcome <em>${user.userName}</em> Loggedin Time <em>${user.loginTS}</em> Current Time  <fmt:formatDate value="<%=new java.util.Date()%>" pattern="dd-MM-yyyy-HH:mm:ss"/>
<c:url value="Home.do" var="logoutUrl">
<c:param name="logout" value="true" />
</c:url>
<p class="logout" align="right"><a href="${logoutUrl}" style="font-size: 15px;">Logout</a></p>
</div>