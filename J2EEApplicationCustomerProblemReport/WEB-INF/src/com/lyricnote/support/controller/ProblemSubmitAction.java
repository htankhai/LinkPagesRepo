/**
*  Copyright (c) 2002 by Phil Hanna
*  All rights reserved.
*  
*  You may study, use, modify, and distribute this
*  software for any purpose provided that this
*  copyright notice appears in all copies.
*  
*  This software is provided without warranty
*  either expressed or implied.
*/
package com.lyricnote.support.controller;

import com.lyricnote.support.model.*;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
* Submits a problem update
*/
public class ProblemSubmitAction extends Action
{
   /**
   * Executes the action
   */
   public void run() throws ServletException, IOException
   {
      // Get the parameters

      String problemID = request.getParameter("problemID");
      String description = request.getParameter("description");
      String severity = request.getParameter("severity");
      String comments = request.getParameter("comments");
      String eventID = request.getParameter("eventID");

      try {

         // Get the problem object from the model

         model.setProblemID(problemID);
         Problem problem = model.getProblem();

         // Update the problem object

         problem.setDescription(description);
         problem.setSeverity(Integer.parseInt(severity));
         if (model.isClosingEvent(eventID)) {
            problem.close();
         }
         model.updateProblem(problem);

         // Add a problem log record

         ProblemLog log = new ProblemLog();
         log.setProblemID(problemID);
         log.setLogTime(new java.util.Date());
         log.setEventID(eventID);
         log.setComments(comments);
         model.addProblemLogEntry(log);
      }
      catch (SQLException e) {
         throw new ServletException(e.getMessage());
      }

      // Forward to confirmation JSP

      final String next = "/Confirm.jsp";
      RequestDispatcher rd =
         application.getRequestDispatcher(next);
      if (rd == null)
         throw new ServletException
         ("Could not find " + next);
      rd.forward(request, response);
   }
}

