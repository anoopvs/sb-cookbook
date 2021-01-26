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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Validator Example Results</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/example.css"/>" />
</head>
<body>
<p><jsp:include page="/jsp/topNav.jsp" flush="true" /></p>
<spring:url value="index.jsp" var="indexUrl"></spring:url>
<spring:url value="/images/return.gif" var="returnUrl"></spring:url>
<a href="${indexUrl}"><img src="${returnUrl}" height="24" width="24" alt="Return to examples page" class="icon" /></a>
<h1>Validator Example Results</h1>
<hr noshade="noshade"/>

<p><strong>Byte:</strong> ${validatorForm.byteValue}</p>
<p><strong>Short:</strong> ${validatorForm.shortValue}</p>
<p><strong>Integer:</strong> ${validatorForm.integerValue}</p>
<p><strong>Long:</strong> ${validatorForm.longValue}</p>
<p><strong>Float:</strong> ${validatorForm.floatValue}</p>
<p><strong>Double:</strong> ${validatorForm.doubleValue}</p>
<p><strong>Credit Card:</strong> ${validatorForm.creditCard}</p>
<p><strong>Date:</strong> ${validatorForm.date}</p>
<p><strong>Email:</strong> ${validatorForm.email}</p>
<p><strong>Mask:</strong> ${validatorForm.mask}</p>
<p><strong>Min Length:</strong> ${validatorForm.min}</p>
<p><strong>Max Length:</strong> ${validatorForm.max}</p>
<p><strong>Range:</strong> ${validatorForm.range}</p>
<p><strong>Required:</strong> ${validatorForm.required}</p>
<p><strong>Password:</strong> ${validatorForm.password}</p>

</body>
</html>