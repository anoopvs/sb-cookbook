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
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Select / Options examples</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/example.css"/>" />
</head>
<body>
<p><jsp:include page="/jsp/topNav.jsp" flush="true" /></p>
	<spring:url value="index.jsp" var="indexUrl"></spring:url>
	<spring:url value="/images/return.gif" var="returnUrl"></spring:url>
	<a href="${indexUrl}"><img src="${returnUrl}" height="24"
		width="24" alt="Return to examples page" class="icon" /></a>
	<h1>Select / Options examples</h1>
	<hr noshade="noshade" />
	<p>View the HTML source to see the generated option values.</p>
	<form:form method="POST" action="processOptions.do"
		modelAttribute="optionsForm">
		<h2>1. Simple select tags</h2>
		<table width="100%" border="0" cellspacing="10" cellpadding="0">
			<tr valign="top">
				<td width="33%">
					<p>Single select, size=&quot;1&quot; (drop down list)</p>
					<p>
						<form:select path="fruit1">
							<form:option value="Strawberry">Strawberry</form:option>
							<form:option value="Apple">Apple</form:option>
							<form:option value="Orange">Orange</form:option>
							<form:option value="Pear">Pear</form:option>
							<form:option value="Mango">Mango</form:option>
							<form:option value="Banana">Banana</form:option>
							<form:option value="Pineapple">Pineapple</form:option>
						</form:select>
					</p>
				</td>
				<td width="33%">
					<p>Single select, size=&quot;4&quot;</p>
					<p>
						<form:select path="fruit2" size="4">
							<form:option value="Strawberry">Strawberry</form:option>
							<form:option value="Apple">Apple</form:option>
							<form:option value="Orange">Orange</form:option>
							<form:option value="Pear">Pear</form:option>
							<form:option value="Mango">Mango</form:option>
							<form:option value="Banana">Banana</form:option>
							<form:option value="Pineapple">Pineapple</form:option>
						</form:select>
					</p>
				</td>
				<td width="33%">
					<p>Multi-select, size=&quot;7&quot;</p>
					<p>
						<form:select path="fruit3" size="7" multiple="true">
							<form:option value="Strawberry">Strawberry</form:option>
							<form:option value="Apple">Apple</form:option>
							<form:option value="Orange">Orange</form:option>
							<form:option value="Pear">Pear</form:option>
							<form:option value="Mango">Mango</form:option>
							<form:option value="Banana">Banana</form:option>
							<form:option value="Pineapple">Pineapple</form:option>
						</form:select>
					</p>
				</td>
			</tr>
		</table>
		<h2>2. Populating options from arrays and collections</h2>
		<table width="100%" border="0" cellspacing="10" cellpadding="0">
			<tr>
				<td width="33%" valign="top">
					<p>Option values and labels populated from the same array:</p>
					<p>
						<form:select path="color1" size="7">
							<form:options items="${colors}" />
						</form:select>
					</p>
				</td>
				<td width="33%" valign="top">
					<p>Option values and labels populated from different arrays:</p>
					<p>

						<form:select path="color2" size="7">
							<form:options items="${colorCodes}" />
						</form:select>
					</p>
				</td>
				<td width="33%" valign="top">
					<p>Option values populated from an array and labels populated
						from a collection:</p>
					<p>
						<form:select path="color3" size="7">
							<form:options items="${colorCodes}" />
						</form:select>
					</p>

				</td>
			</tr>
		</table>
		<h2>3. Populating options from a Collection of LabelValueBeans</h2>
		<table width="100%" border="0" cellspacing="10" cellpadding="0">
			<tr valign="top">
				<td width="33%">
					<p>Options populated from a Collection of LabelValueBeans,
						using &lt;html:options&gt;:</p>
					<p>

						<form:select path="day1" size="7">
							<form:options items="${days}" itemLabel="label" itemValue="value" />
						</form:select>
					</p>
				</td>
				<td width="33%">
					<p>Options populated from a Collection of LabelValueBeans,
						using &lt;html:optionsCollection&gt;:</p>
					<p>
						<form:select path="day1" size="7">
							<form:options items="${days}" itemLabel="label" itemValue="value" />
						</form:select>
					</p>
				</td>
				<td width="33%">&nbsp;</td>
			</tr>
		</table>
		<h2>4. Populating options from a Collection of custom beans</h2>
		<table width="100%" border="0" cellspacing="10" cellpadding="0">
			<tr valign="top">
				<td width="33%">
					<p>
						Options populated from a Collection of BookBeans, using<br />
						&lt;html:options&gt;:
					</p>
					<p>
						<form:select path="book1" size="7">
							<form:options items="${books}" itemLabel="title" itemValue="isbn" />
						</form:select>
					</p>
				</td>
				<td width="33%">
					<p>
						Options populated from a Collection of BookBeans, using<br />
						&lt;html:optionsCollection&gt;:
					</p>
					<p>
						<form:select path="book2" size="7">
							<form:options items="${books}" itemLabel="title" itemValue="isbn" />
						</form:select>
					</p>
				</td>
				<td width="33%">&nbsp;</td>
			</tr>
		</table>
		<h2>4. Populating options from a Map</h2>
		<table width="100%" border="0" cellspacing="10" cellpadding="0">
			<tr valign="top">
				<td width="33%">
					<p>
						Options populated from a Map, using <br /> &lt;html:options&gt;:
					</p>
					<p>
						<form:select path="animal1" size="5">
							<form:options items="${animals}"/>
						</form:select>
					</p>
				</td>
				<td width="33%">
					<p>
						Options populated from a Map, using <br />
						&lt;html:optionsCollection&gt;:
					</p>
					<p>
						<form:select path="animal2" size="5">
							<form:options items="${animals}" />
						</form:select>
					</p>
				</td>
				<td width="33%">&nbsp;</td>
			</tr>
		</table>

		<hr />
		<p>
			<button type="submit">
				<spring:message code="button.submit" />
			</button>
			<button type="submit" name="org.springbridge.action.CANCEL">
				<spring:message code="button.cancel" />
			</button>
			<button type="reset">
				<spring:message code="button.reset" />
			</button>
		</p>
	</form:form>

</body>
</html>