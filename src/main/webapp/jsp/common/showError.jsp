<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/example.css"/>" />
<c:if test="${not empty requestScope['org.springbridge.action.ERROR'] and not empty requestScope['org.springbridge.action.ERROR'].messages}">
<spring:message code="errors.header"/>
<c:forEach var="msg" items="${requestScope['org.springbridge.action.ERROR'].messages}" varStatus="status">
<c:forEach var="msgInner" items="${msg.value}">
	<spring:message code="errors.prefix"/>
	<spring:eval expression="T(org.springframework.util.StringUtils).arrayToCommaDelimitedString(msgInner.values)" var="args"/>
		<c:choose>
			<c:when test="${!msgInner.resource}">
				<spring:message code="${msgInner.key}" arguments="${args}" text="${msgInner.defaultMessage}"/>
			</c:when>
			<c:otherwise>
				<spring:message code="${msgInner.key}" arguments="${args}"/>
			</c:otherwise>
		</c:choose>
	<spring:message code="errors.suffix"/>
</c:forEach> 
</c:forEach>
<spring:message code="errors.footer"/>
</c:if>
