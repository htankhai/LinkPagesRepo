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
import javax.servlet.*;
import javax.servlet.http.*;

/**
* The base class for all state transitions
*/
public abstract class Action implements Serializable
{
   protected transient HttpServletRequest request;
   protected transient HttpServletResponse response;
   protected transient ServletContext application;
   protected Model model;

   /**
   * Executes the action.  Subclasses should override
   * this method and have it forward the request to the
   * next view component when it completes processing.
   */
   public abstract void run()
      throws ServletException, IOException;

   /**
   * Sets the request.
   * @param request the request.
   */
   public void setRequest(HttpServletRequest request)
   {
      this.request = request;
   }

   /**
   * Sets the response
   * @param response the response
   */
   public void setResponse(HttpServletResponse response)
   {
      this.response = response;
   }

   /**
   * Sets the servlet context.
   * @param application the application.
   */
   public void setApplication(ServletContext application)
   {
      this.application = application;
   }

   /**
   * Sets the model.
   * @param model the model.
   */
   public void setModel(Model model)
   {
      this.model = model;
   }
}
