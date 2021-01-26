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
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Simple form using ActionForm</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/example.css"/>" />
</head>
<body>
<spring:url value="index.jsp" var="indexUrl"></spring:url>
<spring:url value="/images/return.gif" var="returnUrl"></spring:url>
<a href="${indexUrl}"><img src="${returnUrl}" height="24" width="24" alt="Return to examples page" class="icon" /></a>
<h1>Simple form using ActionForm</h1>
<hr noshade="noshade"/>

<p>Enter information into the fields below. Your entries will be displayed when you Submit the form.<br />
   This is just to demonstrate the Struts html tags. The information that you enter is discarded.</p>
<p>* = required field</p>
<hr noshade="noshade" />
<jsp:include page="/jsp/common/showError.jsp" flush="true" />
<form:form method="POST" action="processToken.do" modelAttribute="testForm">
	<p>* What's your first name?:<br/>
	<form:input path="name" size="40" maxlength="50"/>
	</p>
	<p>* Enter a secret word or phrase:<br/>
	<form:password path="secret" size="40" maxlength="50"/>
	<p>What is your favorite color?:<br/> 
	<form:select path="color">
		<form:option value="red">Red</form:option>
		<form:option value="green">Green</form:option>
		<form:option value="blue">Blue</form:option>
	</form:select>
    </p>
	<p><form:checkbox path="confirm" value="false"/>Is that really your favorite color?</p>
	<p>How much do you like your chosen color?:<br />
		<form:radiobutton path="rating"  value="1"/>Actually, I hate it.<br />
		<form:radiobutton path="rating"  value="2"/>Not so much.<br />
		<form:radiobutton path="rating"  value="3"/>I'm indifferent<br />
		<form:radiobutton path="rating"  value="4"/>It's pretty neat<br />
		<form:radiobutton path="rating"  value="5"/>I painted my whole house with it.
	</p>	
	<p>Enter a message (you may use html tags):<br />
		<form:textarea path="message" cols="40" rows="6"/>
	</p>
	<form:hidden path="hidden" />
	<hr noshade="noshade" />   
	<p>
		<button type="submit"><spring:message code="button.submit"/></button>
		<button type="submit" name="org.springbridge.action.CANCEL"><spring:message code="button.reset"/></button>
	</p>
</form:form>   
</body>
</html>