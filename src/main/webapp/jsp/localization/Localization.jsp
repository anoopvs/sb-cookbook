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
<title>Localization Example</title>
<p><jsp:include page="/jsp/topNav.jsp" flush="true" /></p>
<spring:url value="index.jsp" var="indexUrl"></spring:url>
<spring:url value="/images/return.gif" var="returnUrl"></spring:url>
<a href="${indexUrl}"><img src="${returnUrl}" height="24" width="24" alt="Return to examples page" class="icon" /></a>
<h1>Localization Example</h1>
<hr noshade="noshade"/>

<h2>
<spring:message code="message.welcome" />
</h2>

<h4>Change Language</h4>
<ul>
<spring:url value="/processLocalization.do" var="actionURL"></spring:url>
   <li><a href="${actionURL}">Default</a></li>
   <li><a href="${actionURL}?language=en">English</a></li>
   <li><a href="${actionURL}?language=en_CA">English (Canadian)</a></li>
   <li><a href="${actionURL}?language=en_US">English (US)</a></li>
   <li><a href="${actionURL}?language=en_GB">English (British)</a></li>
   <li><a href="${actionURL}?language=fr">French</a></li>
   <li><a href="${actionURL}?language=de">German</a></li>
   <li><a href="${actionURL}?language=es">Spanish</a></li>
   <li><a href="${actionURL}?language=it">Italian</a></li>
   <li><a href="${actionURL}?language=pt">Portuguese</a></li>
</ul>

<hr />
<p><strong>Notes:</strong> If I've got the translations wrong please feel free to tell me the correct version. I'm a programmer not a linguist, Jim.</p>

</body>
</html>
