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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
* An update to a reported problem.
*/
public class ProblemLog implements Serializable
{
   private String problemID;
   private java.util.Date logTime;
   private String eventID;
   private String comments;

   /**
   * Creates an empty problem log record
   */
   public ProblemLog()
   {
   }

   /**
   * Factory method to create a problem record
   * from the current row of a result set.
   * @param rs a result set from the problem table
   * @exception SQLException if a database error occurs
   */
   public static ProblemLog load(ResultSet rs)
      throws SQLException
   {
      ProblemLog probLog = new ProblemLog();

      probLog.setProblemID(rs.getString(1));
      probLog.setLogTime(rs.getTimestamp(2));
      probLog.setEventID(rs.getString(3));
      probLog.setComments(rs.getString(4));

      return probLog;
   }

   /**
   * Returns the object as a CSV string
   */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();

      sb.append(getProblemID());
      sb.append(",");
      sb.append(Model.formatDateTime(getLogTime()));
      sb.append(",");
      sb.append(getEventID());
      sb.append(",");
      sb.append(getComments());

      return sb.toString();
   }

   // ===========================================
   //    Property accessor methods
   // ===========================================

   /**
   * Returns the problemID.
   */
   public String getProblemID()
   {
      return problemID;
   }

   /**
   * Sets the problemID.
   * @param problemID the problemID.
   */
   public void setProblemID(String problemID)
   {
      this.problemID = problemID;
   }

   /**
   * Returns the logTime.
   */
   public java.util.Date getLogTime()
   {
      return logTime;
   }

   /**
   * Sets the logTime.
   * @param logTime the logTime.
   */
   public void setLogTime(java.util.Date logTime)
   {
      this.logTime = logTime;
   }

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
   * Returns the comments.
   */
   public String getComments()
   {
      return comments;
   }

   /**
   * Sets the comments.
   * @param comments the comments.
   */
   public void setComments(String comments)
   {
      this.comments = comments;
   }
}
