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

import java.io.*;
import java.sql.*;
import java.util.*;

/**
* An event in the life of a problem
*/
public class Event implements Serializable
{
   private String eventID;
   private String description;
   private boolean isClosingEvent;

   /**
   * Factory method to create an event record
   * from the current row of a result set.
   * @param rs a result set from the event table
   * @exception SQLException if a database error occurs
   */
   public static Event load(ResultSet rs)
      throws SQLException
   {
      Event event = new Event();
      String value = null;

      value = rs.getString(1);
      if (value != null)
         event.setEventID(value);

      value = rs.getString(2);
      if (value != null)
         event.setDescription(value);

      event.setIsClosingEvent(rs.getBoolean(3));

      return event;
   }

   /**
   * Returns the object as a CSV string
   */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();

      sb.append(Model.quote(getEventID()));
      sb.append(",");
      sb.append(Model.quote(getDescription()));
      sb.append(",");
      sb.append(isClosingEvent());

      return sb.toString();
   }

   // ===========================================
   //    Property accessor methods
   // ===========================================

   /**
   * Returns the eventID.
   */
   public String getEventID()
   {
      return eventID;
   }

   /**
   * Sets the eventID.
   * @param eventID the eventID.
   */
   public void setEventID(String eventID)
   {
      this.eventID = eventID;
   }

   /**
   * Returns the description
   */
   public String getDescription()
   {
      return description;
   }

   /**
   * Sets the description
   * @param description the description
   */
   public void setDescription(String description)
   {
      this.description = description;
   }

   /**
   * Returns the isClosingEvent flag
   */
   public boolean isClosingEvent()
   {
      return isClosingEvent;
   }

   /**
   * Sets the isClosingEvent
   * @param isClosingEvent the isClosingEvent
   */
   public void setIsClosingEvent(boolean isClosingEvent)
   {
      this.isClosingEvent = isClosingEvent;
   }

}
