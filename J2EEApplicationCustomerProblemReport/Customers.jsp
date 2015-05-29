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

<jsp:useBean id="model"
             scope="session"
             class="com.lyricnote.support.model.WebModel"/>
<html>
<head>
<title>Customer Search</title>
<jsp:include page="SetBaseURL.jsp" flush="false"/>
<link rel="stylesheet" href="style.css">
</head>

<body>
<jsp:include page="Banner.jsp" flush="false"/>
<h1>Customer Search</h1>
<form method="POST" action="servlet/controller/Customers/Search">
<b>Customer name</b>:
<input type="TEXT" name="customerSearchArgument" size="20">
<input type="SUBMIT" value="Search">
</form>
</body>
</html>
