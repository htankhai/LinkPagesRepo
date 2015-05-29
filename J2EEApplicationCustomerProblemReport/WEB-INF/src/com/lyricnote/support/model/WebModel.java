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
package com.lyricnote.support.model;

import java.sql.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;

/**
* HTTP-specific subclass of Model.  Implements session
* binding and unbinding.  Allows the database connection
* to be disconnected when the session times out or is
* invalidated.
*/
public class WebModel
   extends Model
   implements HttpSessionBindingListener
{
   /**
   * The JNDI string that specifies the data source.
   * Hard coded here; this could be supplied as an
   * input parameter.
   */
   public static final String DATASOURCE =
      "java:comp/env/jdbc/LyricNote";

   /**
   * Implementation of the abstract connect method
   */
   public void connect() throws SQLException
   {
      try {
         InitialContext ctx = new InitialContext();
         DataSource ds = (DataSource) ctx.lookup(DATASOURCE);
         Connection con = ds.getConnection();
         setConnection(con);
      }
      catch (NamingException e) {
         throw new SQLException(e.getMessage());
      }
   }

   /**
   * Called when the model is bound to a session
   */
   public void valueBound(HttpSessionBindingEvent event)
   {
      // Connect to the database

      try {
         connect();
      }
      catch (SQLException e) {
         e.printStackTrace();
      }
   }

   /**
   * Called when the model is removed from a session
   */
   public void valueUnbound(HttpSessionBindingEvent event)
   {
      try {
         disconnect();
      }
      catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
