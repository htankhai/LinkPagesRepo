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

<%-- Page included from Customer.jsp to display the
     list of problems reported by this customer --%>

<jsp:useBean id="model"
             scope="session"
             type="com.lyricnote.support.model.WebModel"/>

<table border="0" cellspacing="5" cellpadding="0">
<%
   List list = model.getProblems();
   if (list != null && list.size() > 0) {
%>
<tr>
   <th align="LEFT">Problem ID</th>
   <th align="LEFT">Description</th>
   <th align="LEFT">Date Reported</th>
   <th align="LEFT">Date Resolved</th>
</tr>
<%
   Iterator it = list.iterator();
   while (it.hasNext()) {
      request.setAttribute("problem", it.next());
%>
<jsp:useBean id="problem"
             scope="request"
             type="com.lyricnote.support.model.Problem"/>
<tr>
<td><a href=
   '<%= "servlet/controller/Problems/Select?problemID="
      + problem.getProblemID() %>'
   ><jsp:getProperty name="problem" property="problemID"/></a>
   &nbsp;
</td>
<td>
<jsp:getProperty name="problem" property="description"/>&nbsp;
</td>
<td><%= Model.formatDateTime(problem.getDateReported()) %></td>
<td><%= Model.formatDateTime(problem.getDateResolved()) %></td>
</tr>
<%
      }
   }
%>
</table>
