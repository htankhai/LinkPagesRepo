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
<%@ page import="java.util.*" %>
<%@ page import="com.lyricnote.support.model.*" %>

<%-- Included from Problem.jsp to display problem history --%>

<jsp:useBean id="model"
             scope="session"
             type="com.lyricnote.support.model.Model"/>

<jsp:useBean id="problem"
             scope="request"
             type="com.lyricnote.support.model.Problem"/>
<%
   model.problemLogSearch(problem.getProblemID());
   List problemLogs = model.getProblemLogs();
   if (problemLogs.size() > 0) {
%>
<table border="1" cellpadding="3" cellspacing="0">
<tr>
<th>Time</th>
<th>Event Code</th>
<th>Comments</th>
</tr>
<%
   Iterator it = problemLogs.iterator();
   while (it.hasNext()) {
      ProblemLog log = (ProblemLog) it.next();
%>
<tr>
<td><%= Model.formatDateTime(log.getLogTime()) %></td>
<td><%= log.getEventID() %></td>
<td><%= log.getComments() %>&nbsp;</td>
</tr>
<% } %>
</table>
<% } %>
