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
* Gets detailed information for this customer
*/
public class CustomersListSelectAction extends Action
{
   /**
   * Executes the action
   */
   public void run() throws ServletException, IOException
   {
      // Get customer ID and store it in the model

      String customerID = request.getParameter("customerID");
      if (customerID == null)
         throw new ServletException
         ("No customer ID specified");
      model.setCustomerID(customerID);

      // Get the list of problems for this customer

      try {
         model.customerProblemsSearch(customerID);
      }
      catch (SQLException e) {
         throw new ServletException(e.getMessage());
      }

      // Forward to customer detail JSP

      final String next = "/Customer.jsp";
      RequestDispatcher rd =
         application.getRequestDispatcher(next);
      if (rd == null)
         throw new ServletException
         ("Could not find " + next);
      rd.forward(request, response);
   }
}
