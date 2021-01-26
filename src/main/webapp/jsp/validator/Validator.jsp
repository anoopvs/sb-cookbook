<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at
   
         http://www.apache.org/licenses/LICENSE-2.0
   
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Validator Example using DynaValidatorActionForm</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/example.css"/>" />
</head>
<body>
<p><jsp:include page="/jsp/topNav.jsp" flush="true" /></p>
<spring:url value="index.jsp" var="indexUrl"></spring:url>
<spring:url value="/images/return.gif" var="returnUrl"></spring:url>
<a href="${indexUrl}"><img src="${returnUrl}" height="24" width="24" alt="Return to examples page" class="icon" /></a>

<h1>Validator Example using DynaValidatorActionForm</h1>
<hr noshade="noshade"/>
<p>Enter information into the fields below. Your entries will be displayed when you Submit the form.</p>
<p>* = required field. Other fields must be blank or in the required format.</p>
<hr noshade="noshade" />   
<jsp:include page="/jsp/common/showError.jsp" flush="true" />
<form:form action="processValidator.do" modelAttribute="validatorForm" method="post">

	<table>
	<tr><td>Byte:</td><td><form:input path="byteValue" /> -128 .. 127</td></tr>
	<tr><td>Short:</td><td><form:input path="shortValue" /> -32768 .. 32767</td></tr>
	<tr><td>Integer:</td><td><form:input path="integerValue" /> -2147483648 .. 2147483647</td></tr>
	<tr><td>Long:</td><td><form:input path="longValue" /> -9223372036854775808 .. 9223372036854775807</td></tr>
	<tr><td>Float:</td><td><form:input path="floatValue" /> 1.4E-45 .. 3.4028235E38</td></tr>
	<tr><td>Double:</td><td><form:input path="doubleValue" /> 4.9E-324 .. 1.7976931348623157E308</td></tr>
	<tr><td>Credit Card:</td><td><form:input path="creditCard" /> e.g. 4444333322221111 (no spaces) </td></tr>
	<tr><td>Date:</td><td><form:input path="date" /> mm/dd/yyyy</td></tr>
	<tr><td>Email:</td><td><form:input path="email" /></td></tr>
	<tr><td>Mask:</td><td><form:input path="mask" /> US zip code e.g. 90210</td></tr>
	<tr><td>Min Length:</td><td><form:input path="min" /> (minimum 5 characters)</td></tr>
	<tr><td>Max Length:</td><td><form:input path="max" /> (maximum 10 characters)</td></tr>
	<tr><td>Range:</td><td><form:input path="range" /> 100 .. 1000</td></tr>
	<tr><td>* Required:</td><td><form:input path="required" /></td></tr>
	</table>
	<p>These two fields must contain the same value:</p>
	<table>
	<tr><td>* Password:</td><td><form:password path="password" redisplay="false"/> (minimum 5 characters)</td></tr>
	<tr><td>* Password confirmation:</td><td><form:password path="password2"  redisplay="false"/></td></tr>
	</table>

	<hr noshade="noshade" />   
	<p>
			<button type="submit">
				<spring:message code="button.submit" />
			</button>
					<button type="submit" name="org.springbridge.action.CANCEL">
				<spring:message code="button.cancel" />
			</button>
	</p>
</form:form>

</body>
</html>