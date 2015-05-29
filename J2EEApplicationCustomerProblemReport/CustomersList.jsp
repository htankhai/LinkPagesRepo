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

<jsp:useBean id="model"
             scope="session"
             class="com.lyricnote.support.model.WebModel"/>
<html>
<head>
<title>Customers List</title>
<jsp:include page="SetBaseURL.jsp" flush="false"/>
<link rel="stylesheet" href="style.css">
</head>

<body>
<jsp:include page="Banner.jsp" flush="false"/>
<h1>Customers List</h1>
<table border="0" cellspacing="5" cellpadding="0">
<tr>
<th align="LEFT">Customer ID</th>
<th align="LEFT">Customer Name</th>
</tr>
<%
   List list = model.getCustomers();
   if (list != null) {
      Iterator it = list.iterator();
      while (it.hasNext()) {
         request.setAttribute("customer", it.next());
%>
<jsp:useBean id="customer"
             scope="request"
             type="com.lyricnote.support.model.Customer"/>
<tr>
<td>
<a href='<%=
   "servlet/controller/CustomersList/Select?customerID="
   + customer.getCustomerID() %>'>
<jsp:getProperty name="customer" property="customerID"/></a>
</td>
<td><jsp:getProperty name="customer" property="name"/></td>
</tr>
<% }} %>

</table>

</body>
</html>
