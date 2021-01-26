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
<title>Token Example Results</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/example.css"/>" />
</head>
<body>
<spring:url value="index.jsp" var="indexUrl"></spring:url>
<spring:url value="/images/return.gif" var="returnUrl"></spring:url>
<a href="${indexUrl}"><img src="${returnUrl}" height="24" width="24" alt="Return to examples page" class="icon" /></a>
<h1>Token Example Results</h1>
<hr noshade="noshade"/>

<p>The form has been submitted.</p>
<p>You can cause a duplicate submission by either: 
<ol>
<li>Using your browser back button to return to the previous page and resubmitting the form.</li>
<li>Refeshing this page and selecting OK when your browser asks if you want to resubmit the data.</li>
</ol>
In either case, the input form page will be displayed, along with an error message explaining that the form has been submitted out of sequence.

<p><strong>Important:</strong> This example demonstrates how you can prevent <em>unintentional</em> form resubmission. 
The token is reset before the input form is redisplayed. This means that once the user has been notified of the attempted
duplicate submission they can then <em>choose</em> whether to resubmit the form.</p>

</body>
</html>