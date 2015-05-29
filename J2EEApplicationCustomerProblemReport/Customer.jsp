<%--
  Copyright (c) 2002 by Phil Hanna
  All rights reserved.
  
  You may study, use, modify, and distribute this
  software for any purpose provided that this
  copyright notice appears in all copies.
  
  This software is provided without warranty
  either expressed or implied.
--%>
<%@ page session="true" %>
<%@ page errorPage="ErrorPage.jsp" %>
<%@ page import="com.lyricnote.support.model.*" %>

<%-- Displays customer details, using included pages
     to do each major section --%>

<jsp:useBean id="model"
             scope="session"
             class="com.lyricnote.support.model.WebModel"/>
<%
   request.setAttribute("customer", model.getCustomer());
%>
<jsp:useBean id="customer"
             scope="request"
             type="com.lyricnote.support.model.Customer"/>
<html>
<head>
<title>Customer Detail</title>
<jsp:include page="SetBaseURL.jsp" flush="false"/>
<link rel="stylesheet" href="style.css">
</head>

<body>
<jsp:include page="Banner.jsp" flush="false"/>
<h1>Customer Detail</h1>
<table border="0" cellspacing="0" cellpadding="0">
<tr>
   <td valign="TOP">
   <jsp:include page="CustomerInfo.jsp" flush="false"/>
   </td>
   <td valign="TOP">
   <jsp:include page="CustomerProductInfo.jsp" flush="false"/>
   </td>
</tr>
</table>
<hr width="506" align="LEFT">
<jsp:include page="CustomerProblemInfo.jsp" flush="false"/>
</body>
</html>
