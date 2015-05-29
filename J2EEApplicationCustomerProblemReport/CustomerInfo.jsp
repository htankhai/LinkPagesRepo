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

<%-- Page included from Customer.jsp to display
     customer ID, name, and phone section --%>

<jsp:useBean id="customer"
             scope="request"
             type="com.lyricnote.support.model.Customer"/>

<table border="0" cellspacing="5" cellpadding="0">
<tr>
<td><b>Customer ID:</b></td>
<td>
<jsp:getProperty name="customer" property="customerID"/>&nbsp;
</td>
<td rowspan="3"></td>
</tr>
<tr>
<td><b>Name:</b></td>
<td>
<jsp:getProperty name="customer" property="name"/>&nbsp;
</td>
</tr>
<tr>
<td><b>Phone:</b></td>
<td>
<jsp:getProperty name="customer" property="phone"/>&nbsp;
</td>
</tr>
</table>
