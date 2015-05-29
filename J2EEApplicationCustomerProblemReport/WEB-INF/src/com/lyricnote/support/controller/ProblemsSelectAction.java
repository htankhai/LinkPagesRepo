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

import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
* Sets the current problem ID
*/
public class ProblemsSelectAction extends Action
{
   /**
   * Executes the action
   */
   public void run() throws ServletException, IOException
   {
      String problemID = request.getParameter("problemID");
      if (problemID != null) {
         problemID = problemID.trim();
         if (!problemID.equals("")) {
            model.setProblemID(problemID);
         }
      }

      // Forward to problem JSP

      final String next = "/Problem.jsp";
      RequestDispatcher rd =
         application.getRequestDispatcher(next);
      if (rd == null)
         throw new ServletException
         ("Could not find " + next);
      rd.forward(request, response);
   }
}

