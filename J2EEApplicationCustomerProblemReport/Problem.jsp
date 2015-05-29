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

<%-- Displays problem details, calling subpages
     to handle major sections --%>

<jsp:useBean id="model"
             scope="session"
             class="com.lyricnote.support.model.WebModel"/>
<%
   request.setAttribute("problem", model.getProblem());
%>
<jsp:useBean id="problem"
             scope="request"
             class="com.lyricnote.support.model.Problem"/>
<%
   model.setCustomerID(problem.getCustomerID());
   request.setAttribute("customer", model.getCustomer());
%>
<jsp:useBean id="customer"
             scope="request"
             class="com.lyricnote.support.model.Customer"/>
<%
   model.setProductID(problem.getProductID());
   request.setAttribute("product", model.getProduct());
%>
<jsp:useBean id="product"
             scope="request"
             class="com.lyricnote.support.model.Product"/>
<html>
<head>
<title>Problem</title>
<jsp:include page="SetBaseURL.jsp" flush="false"/>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="Banner.jsp" flush="false"/>
<h1>Problem
   <jsp:getProperty name="problem" property="problemID"/>
</h1>
<jsp:include page="ProblemInfo.jsp"/>
<jsp:include page="ProblemHistory.jsp"/>
</body>
</html>
