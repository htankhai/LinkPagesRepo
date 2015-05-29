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

<%-- Displays confirmation of problem update --%>

<jsp:useBean id="model"
             scope="session"
             type="com.lyricnote.support.model.WebModel"/>
<html>
<head>
<title>Confirmation</title>
<jsp:include page="SetBaseURL.jsp" flush="false"/>
<link rel="stylesheet" href="style.css">
</head>

<body>
<jsp:include page="Banner.jsp" flush="false"/>
<h1>Confirmation</h1>

<table border="0" cellpadding="3" cellspacing="0">
<tr>
   <td>Problem ID:</td>
   <td><%= request.getParameter("problemID") %>&nbsp;</td>
</tr>
<tr>
   <td>Description:</td>
   <td><%= request.getParameter("description") %>&nbsp;</td>
</tr>
<tr>
   <td>Severity:</td>
   <td><%= request.getParameter("severity") %>&nbsp;</td>
</tr>
<tr>
   <td>Comments:</td>
   <td><%= request.getParameter("comments") %>&nbsp;</td>
</tr>
<tr>
   <td>EventID:</td>
   <td><%= request.getParameter("eventID") %>&nbsp;</td>
</tr>
</table>

</body>
</html>
