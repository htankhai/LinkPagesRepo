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
<%@ page import="java.util.*" %>

<%-- Displays the list of problems associated with
     this product --%>

<jsp:useBean id="model"
             scope="session"
             class="com.lyricnote.support.model.WebModel"/>
<html>
<head>
<title>Problems by Product</title>
<jsp:include page="SetBaseURL.jsp" flush="false"/>
<link rel="stylesheet" href="style.css">
</head>

<body>
<jsp:include page="Banner.jsp" flush="false"/>
<h1>Problems by Product</h1>
<%
   request.setAttribute("product", model.getProduct());
%>
<jsp:useBean id="product"
             scope="request"
             type="com.lyricnote.support.model.Product"/>
<b>Product:</b>
<jsp:getProperty name="product" property="productID"/>
- <jsp:getProperty name="product" property="name"/>
<table border="0" cellspacing="5" cellpadding="0">
   <tr>
      <th align="LEFT">Problem ID</th>
      <th align="LEFT">Description</th>
      <th align="LEFT">Date Reported</th>
      <th align="LEFT">Date Resolved</th>
   </tr>
<%
   List list = model.getProblems();
   if (list != null) {
      Iterator it = list.iterator();
      while (it.hasNext()) {
         request.setAttribute("problem", it.next());
%>
<jsp:useBean id="problem"
             scope="request"
             type="com.lyricnote.support.model.Problem"/>
<tr>
<td><a href='<%= 
   "servlet/controller/Problems/Select?problemID="
   + problem.getProblemID() %>'>
<jsp:getProperty name="problem" property="problemID"/></a></td>
<td><jsp:getProperty name="problem" property="description"/></td>
<td><%= Model.formatDate(problem.getDateReported()) %></td>
<td><%= Model.formatDate(problem.getDateResolved()) %></td>
</tr>
<% }} %>
</table>

</body>
</html>
