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

<%-- Displays the list of products matching the
     search argument --%>

<jsp:useBean id="model"
             scope="session"
             class="com.lyricnote.support.model.WebModel"/>
<html>
<head>
<title>Products List</title>
<jsp:include page="SetBaseURL.jsp" flush="false"/>
<link rel="stylesheet" href="style.css">
</head>

<body>
<jsp:include page="Banner.jsp" flush="false"/>
<h1>Products List</h1>
<table border=0 cellspacing=5 cellpadding=0>
<tr>
<th align="LEFT">Product ID</th>
<th align="LEFT">Product Name</th>
<th align="LEFT">Support</th>
<th align="LEFT">Developer</th>
<th align="LEFT">Tester</th>
</tr>
<%
   List list = model.getProducts();
   if (list != null) {
      Iterator it = list.iterator();
      while (it.hasNext()) {
         request.setAttribute("product", it.next());
%>
<jsp:useBean id="product"
             scope="request"
             type="com.lyricnote.support.model.Product"/>
<tr>
<td>
<a href='<%=
   "servlet/controller/ProductsList/Select?productID="
   + product.getProductID()
   %>'><jsp:getProperty name="product" property="productID"/>
</a>
</td>
<td><jsp:getProperty name="product" property="name"/></td>
<td>
<%= model.getEmployee(product.getProductSupport()).getName() %>
</td>
<td>
<%= model.getEmployee(product.getDeveloper()).getName() %>
</td>
<td>
<%= model.getEmployee(product.getTester()).getName() %>
</td>
</tr>
<% }} %>

</table>
</body>
</html>
