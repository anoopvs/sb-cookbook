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
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Select / Options example results</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/example.css"/>" />
</head>
<body>
<p><jsp:include page="/jsp/topNav.jsp" flush="true" /></p>
<spring:url value="index.jsp" var="indexUrl"></spring:url>
	<spring:url value="/images/return.gif" var="returnUrl"></spring:url>
	<a href="${indexUrl}"><img src="${returnUrl}" height="24"
		width="24" alt="Return to examples page" class="icon" /></a>
<h1>Select / Options example results</h1>
<hr noshade="noshade"/>

<p>Fruit 1: ${optionsForm.fruit1}</p>
<p>Fruit 2: ${optionsForm.fruit2}</p>
<p>Fruit 3:
<c:forEach items="${optionsForm.fruit3}" var="fruit">
	${fruit}
</c:forEach>
</p>

<p>Color 1: ${optionsForm.color1}</p>
<p>Color 2: ${optionsForm.color2}</p>
<p>Color 3: ${optionsForm.color3}</p>

<p>Day 1: ${optionsForm.day1}</p>
<p>Day 2: ${optionsForm.day2}</p>

<p>Book 1: ${optionsForm.book1}</p>
<p>Book 2: ${optionsForm.book2}</p>

<p>Animal 1: ${optionsForm.animal1}</p>
<p>Animal 2: ${optionsForm.animal2}</p>

</body>
</html>