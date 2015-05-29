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
import java.util.*;
import java.util.Date;
import java.text.*;

/**
* A software problem supported by the Problem
* Support system.
*/
public class Problem implements java.io.Serializable
{
   private String problemID;
   private String description;
   private int severity;
   private Date dateReported;
   private Date dateResolved;
   private String customerID;
   private String productID;

   /**
   * Factory method to create a problem record
   * from the current row of a result set.
   * @param rs a result set from the problem table
   * @exception SQLException if a database error occurs
   */
   public static Problem load(ResultSet rs)
      throws SQLException
   {
      Problem problem = new Problem();

      problem.setProblemID(rs.getString(1));
      problem.setDescription(rs.getString(2));
      problem.setSeverity(rs.getInt(3));
      problem.setDateReported(rs.getTimestamp(4));
      problem.setDateResolved(rs.getTimestamp(5));
      problem.setCustomerID(rs.getString(6));
      problem.setProductID(rs.getString(7));

      return problem;
   }

   /**
   * Returns the object as a CSV string
   */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();

      sb.append(getProblemID());
      sb.append(",");
      sb.append(getDescription());
      sb.append(",");
      sb.append(getSeverity());
      sb.append(",");
      sb.append(Model.formatDateTime(getDateReported()));
      sb.append(",");
      sb.append(Model.formatDateTime(getDateResolved()));
      sb.append(",");
      sb.append(getCustomerID());
      sb.append(",");
      sb.append(getProductID());

      return sb.toString();
   }

   /**
   * Closes the problem
   */
   public void close()
   {
      setDateResolved(Model.toTimestamp(new Date()));
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
   * Returns the description.
   */
   public String getDescription()
   {
      return description;
   }

   /**
   * Sets the description.
   * @param description the description.
   */
   public void setDescription(String description)
   {
      this.description = description;
   }

   /**
   * Returns the severity.
   */
   public int getSeverity()
   {
      return severity;
   }

   /**
   * Sets the severity.
   * @param severity the severity.
   */
   public void setSeverity(int severity)
   {
      this.severity = severity;
   }

   /**
   * Returns the dateReported.
   */
   public Date getDateReported()
   {
      return dateReported;
   }

   /**
   * Sets the dateReported.
   * @param dateReported the dateReported.
   */
   public void setDateReported(Date dateReported)
   {
      this.dateReported = dateReported;
   }

   /**
   * Returns the dateResolved.
   */
   public Date getDateResolved()
   {
      return dateResolved;
   }

   /**
   * Sets the dateResolved.
   * @param dateResolved the dateResolved.
   */
   public void setDateResolved(Date dateResolved)
   {
      this.dateResolved = dateResolved;
   }

   /**
   * Returns the customerID.
   */
   public String getCustomerID()
   {
      return customerID;
   }

   /**
   * Sets the customerID.
   * @param customerID the customerID.
   */
   public void setCustomerID(String customerID)
   {
      this.customerID = customerID;
   }

   /**
   * Returns the productID.
   */
   public String getProductID()
   {
      return productID;
   }

   /**
   * Sets the productID.
   * @param productID the productID.
   */
   public void setProductID(String productID)
   {
      this.productID = productID;
   }

   /**
   * Assigns a globally unique problem ID
   */
   public static synchronized String assignProblemID
      (Connection con) throws SQLException
   {
      String id = null;

      final String SQL_QUERY =
         "select problemID from nextProblemID";

      final String SQL_UPDATE =
         "update nextProblemID set problemID = ?";

      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(SQL_QUERY);
      if (!rs.next())
         throw new SQLException("No record found");
      id = rs.getString(1);
      rs.close();
      stmt.close();

      String nextID = incrementProblemID(id);

      PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE);
      pstmt.setString(1, nextID);
      pstmt.executeUpdate();
      pstmt.close();

      return id;
   }

   /**
   * Helper method to generate the next problem ID
   * from the last one.
   */
   public static String incrementProblemID(String id)
   {
      char prefix = id.charAt(0);
      int suffix = Integer.parseInt(id.substring(1));
      DecimalFormat fmt = new DecimalFormat("00000000");
      String nextSuffix = fmt.format(suffix+1).substring(1);
      String nextID = prefix + nextSuffix;
      return nextID;
   }
}
