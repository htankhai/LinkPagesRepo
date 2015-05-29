<%--
  Copyright (c) 2002 by Phil Hanna
  All rights reserved.
  
  You may study, use, modify, and distribute this
  software for any purpose provided that this
  copyright notice appears in all copies.
  
  This software is provided without warranty
  either expressed or implied.
--%>
<%@ page session="false" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page isErrorPage="true" %>

<html>
<head>
<title>Error Page</title>
<jsp:include page="SetBaseURL.jsp" flush="false"/>
<link rel="stylesheet" href="style.css">
</head>

<body>
<h1>Error</h1>
The following error occurred:
<pre>
<%
   exception.printStackTrace(new PrintWriter(out));
%>
</pre>
</body>
</html>
