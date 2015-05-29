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
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
* The controller component of the Model-View-Controller
* architecure for the LyricNote problem reporting system
*/
public class ControllerServlet extends HttpServlet
{
   /**
   * Handles an HTTP GET request
   */
   public void doGet(
         HttpServletRequest request,
         HttpServletResponse response)
      throws ServletException, IOException
   {
      doPost(request, response);
   }

   /**
   * Handles an HTTP POST request
   */
   public void doPost(
         HttpServletRequest request,
         HttpServletResponse response)
      throws ServletException, IOException
   {
      HttpSession session = request.getSession();
      Map actionMap = (Map) session.getAttribute("actionMap");
      if (actionMap == null) {
         actionMap = new HashMap();
         session.setAttribute("actionMap", actionMap);
      }
      ServletContext context = getServletContext();
      try {

         // Get the state and event from the path info

         String pathInfo = request.getPathInfo();
         if (pathInfo == null)
            throw new ServletException
            ("Invalid internal state - no path info");

         // Load the action object that handles
         // this state and event

         Action action = (Action) actionMap.get(pathInfo);
         if (action == null) {

            // This is the first time the servlet has seen
            // this action.  Get the state and event name
            // from pathInfo.

            StringTokenizer st =
               new StringTokenizer(pathInfo, "/");

            if (st.countTokens() != 2)
               throw new ServletException
               ("Invalid internal state - invalid path info ["
               + pathInfo + "]");
            
            String state = st.nextToken();
            String event = st.nextToken();

            // Form the class name from the state and event

            String className =
               "com.lyricnote.support.controller."
               + state + event + "Action";

            // Load the class and create an instance

            try {
               Class actionClass = Class.forName(className);
               action = (Action) actionClass.newInstance();
            }
            catch (ClassNotFoundException e) {
               throw new ServletException
               ("Could not load class " + className
               + ": " + e.getMessage());
            }
            catch (InstantiationException e) {
               throw new ServletException
               ("Could not create an instance of "
               + className + ": " + e.getMessage());
            }
            catch (IllegalAccessException e) {
               throw new ServletException
               (className + ": " + e.getMessage());
            }

            // Cache the instance in the action map

            actionMap.put(pathInfo, action);
         }

         // Ensure that a model exists in the session.

         Model model = (Model) session.getAttribute("model");
         if (model == null)
            throw new ServletException
            ("No model found in session");

         // Now execute the action.  The action should perform
         // a RequestDispatcher.forward() when it completes

         action.setRequest(request);
         action.setResponse(response);
         action.setApplication(context);
         action.setModel(model);
         action.run();
      }
      catch (ServletException e) {

         // Use the JSP error page for all servlet errors

         request.setAttribute("javax.servlet.jsp.jspException", e);
         RequestDispatcher rd =
            context.getRequestDispatcher("/ErrorPage.jsp");

         if (response.isCommitted())
            rd.include(request, response);
         else
            rd.forward(request, response);
      }
   }
}
