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
* Searches the database for products matching the
* product search argument
*/
public class ProductsSearchAction extends Action
{
   /**
   * Executes the action
   */
   public void run() throws ServletException, IOException
   {
      // Perform search

      String arg = request.getParameter("productSearchArgument");
      if (arg != null) {
         arg = arg.trim();
         if (!arg.equals("")) {
            try {
               model.productSearch(arg);
            }
            catch (SQLException e) {
               throw new ServletException(e.getMessage());
            }
         }
      }

      // Forward to product list JSP

      final String next = "/ProductsList.jsp";
      RequestDispatcher rd =
         application.getRequestDispatcher(next);
      if (rd == null)
         throw new ServletException
         ("Could not find " + next);
      rd.forward(request, response);
   }
}
