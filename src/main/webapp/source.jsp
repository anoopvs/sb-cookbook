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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>View Source</title>
<link rel="stylesheet" type="text/css" href="css/example.css" />
</head>
<body>
<c:set var="srcfile" value="${param.src}"/>
<%--

<spring:eval expression="@getSBWebAppResourceLoader.getResource(srcfile).getInputStream()" var="src"></spring:eval>
<spring:eval  expression="T(java.nio.charset.Charset).defaultCharset()" var="charset"></spring:eval>
 --%>
<spring:eval  expression="T(org.springframework.util.StreamUtils).copyToString(@applicationContextUtils.getApplicationContext().getResource(srcfile).getInputStream(),T(java.nio.charset.Charset).defaultCharset())" var="fileContent"></spring:eval>
<p><strong>Viewing: </strong>${srcfile}</p>
<hr noshade="noshade" />
<pre>
<c:out value="${fileContent}" escapeXml="true"></c:out>
</pre>
</body>
</html>
