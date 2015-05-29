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

<%-- Page included from Customer.jsp that displays
     list of products purchased by this customer --%>

<jsp:useBean id="model"
             scope="session"
             type="com.lyricnote.support.model.WebModel"/>

<jsp:useBean id="customer"
             scope="request"
             type="com.lyricnote.support.model.Customer"/>

<table border="0" cellspacing="5" cellpadding="0">
<tr>
   <th>Product Name</th>
   <th>Date Purchased</th>
</tr>
<%
   List products = model.getCustomerProducts();
   if ((products != null) && (products.size() > 0)) {
      Iterator it = products.iterator();
      while (it.hasNext()) {
         request.setAttribute("custprod", it.next());
%>
<jsp:useBean id="custprod"
             scope="request"
             type="com.lyricnote.support.model.CustomerProduct"/>
<%
   model.setProductID(custprod.getProductID());
   request.setAttribute("product", model.getProduct());
%>
<jsp:useBean id="product"
             scope="request"
             type="com.lyricnote.support.model.Product"/>
<tr>
<td>
<a href='<%=
   "servlet/controller/Customer/NewProblem"
      + "?customerID=" + custprod.getCustomerID()
      + "&productID=" + custprod.getProductID()
   %>'>
<jsp:getProperty name="product" property="name"/>
</a>
</td>
<td><%= Model.formatDate(custprod.getDatePurchased()) %></td>
</tr>
<% } %>
<tr>
<td class="fineprint" colspan="2">
Click product name to report new problem.
</td>
</tr>
<% } %>
</table>
