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

<%-- Included from Problem.jsp to generate the
     problem details and update section --%>

<jsp:useBean id="problem"
             scope="request"
             type="com.lyricnote.support.model.Problem"/>

<jsp:useBean id="customer"
             scope="request"
             type="com.lyricnote.support.model.Customer"/>

<jsp:useBean id="product"
             scope="request"
             type="com.lyricnote.support.model.Product"/>

<form method="POST" action="servlet/controller/Problem/Submit">
<input type="HIDDEN"
       name="problemID"
       value="<jsp:getProperty name='problem'
                     property='problemID'/>">
<table border="0" cellspacing="5" cellpadding="3">
<tr>
<td><b>Description:</b></td>
<td>
<input type="TEXT"
       name="description"
       size="50"
       value="<jsp:getProperty name='problem'
                  property='description'/>">
</td>
</tr>
<tr>
<td><b>Severity:</b></td>
<td>
<input name="severity" type="radio" value="1"
   <%= problem.getSeverity() == 1 ? "CHECKED" : "" %>> High
<input name="severity" type="radio" value="2"
   <%= problem.getSeverity() == 2 ? "CHECKED" : "" %>> Medium
<input name="severity" type="radio" value="3"
   <%= problem.getSeverity() == 3 ? "CHECKED" : "" %>> Low
</td>
</tr>
<tr>
<td><b>Customer:</b></td>
<td><jsp:getProperty name="customer" property="name"/></td>
</tr>
<tr>
<td><b>Product:</b></td>
<td><jsp:getProperty name="product" property="name"/></td>
</tr>
<tr>
<td><b>Date</b></td>
<td>
<b>Reported:</b>
<%= Model.formatDateTime(problem.getDateReported()) %>
<br/>
<b>Resolved:</b>
<%= Model.formatDateTime(problem.getDateResolved()) %>
</td>
</tr>
<tr>
<td><b>Comments:</b></td>
<td>
<textarea name="comments" cols="50" rows="4">
</textarea>
</td>
</tr>
<tr>
<td><b>Action:</b></td>
<td>
<select name="eventID">
<option value="COM">Comments</option>
<option value="CSI">Customer interviewed</option>
<option value="RPS">Routed to product support</option>
<option value="RPD">Routed to development</option>
<option value="RQA">Routed to test</option>
<option value="DEF">Deferred</option>
<option value="CNB">Closed - not a bug</option>
<option value="CCP">Closed - customer problem</option>
<option value="CFX">Closed - fixed</option>
</select>
<input type="SUBMIT" value="Submit">
</td>
</tr>
</table>
</form>
