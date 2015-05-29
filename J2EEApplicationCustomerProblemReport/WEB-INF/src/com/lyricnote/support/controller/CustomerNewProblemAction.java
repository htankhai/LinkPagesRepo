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

public class CustomerNewProblemAction extends Action
{
   /**
   * Executes the action
   */
   public void run() throws ServletException, IOException
   {
      // Get the customer ID and product ID

      String customerID = request.getParameter("customerID");
      if (customerID == null)
         throw new ServletException
         ("No customer ID");

      String productID = request.getParameter("productID");
      if (productID == null)
         throw new ServletException
         ("No product ID");

      // Create a new problem

      try {
         model.setCustomerID(customerID);
         model.setProductID(productID);
         model.newProblem();
      }
      catch (SQLException e) {
         throw new ServletException(e.getMessage());
      }

      // Forward to problem detail JSP

      final String next = "/Problem.jsp";
      RequestDispatcher rd =
         application.getRequestDispatcher(next);
      if (rd == null)
         throw new ServletException
         ("Could not find " + next);
      rd.forward(request, response);
   }
}
