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
<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>

<%-- Sets the base URL for the application so that relative
     references can be used in non-JSP elements --%>
<%
   StringBuffer sb = request.getRequestURL();
   String path = sb.toString();
   URL url = new URL(path);

   sb = new StringBuffer();
   sb.append(url.getProtocol());
   sb.append("://");
   sb.append(url.getHost());
   int port = url.getPort();
   if (port != -1) {
      sb.append(":");
      sb.append(port);
   }
   sb.append(request.getContextPath());
   sb.append("/");
   path = sb.toString();
%>
<base href="<%= path %>"/>
