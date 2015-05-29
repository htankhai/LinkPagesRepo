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
* A LyricNote employee who uses the Product Support system.
*/
public class Employee implements Serializable
{
   private String employeeID;
   private String name;
   private Date dateHired;
   private boolean isManager;
   private String departmentID;
   private String title;
   private String email;
   private String phone;

   /**
   * Factory method to create an employee record
   * from the current row of a result set.
   * @param rs a result set from the employee table
   * @exception SQLException if a database error occurs
   */
   public static Employee load(ResultSet rs)
      throws SQLException
   {
      Employee employee = new Employee();

      employee.setEmployeeID(rs.getString(1));
      employee.setName(rs.getString(2));
      employee.setDateHired(rs.getDate(3));
      employee.setIsManager(rs.getBoolean(4));
      employee.setDepartmentID(rs.getString(5));
      employee.setTitle(rs.getString(6));
      employee.setEmail(rs.getString(7));
      employee.setPhone(rs.getString(8));

      return employee;
   }

   /**
   * Returns the object as a CSV string
   */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();

      sb.append(getEmployeeID());
      sb.append(",");
      sb.append(Model.quote(getName()));
      sb.append(",");
      sb.append(Model.formatDate(getDateHired()));
      sb.append(",");
      sb.append(getIsManager());
      sb.append(",");
      sb.append(getDepartmentID());
      sb.append(",");
      sb.append(Model.quote(getTitle()));
      sb.append(",");
      sb.append(getEmail());
      sb.append(",");
      sb.append(getPhone());

      return sb.toString();
   }

   // ===========================================
   //    Property accessor methods
   // ===========================================

   /**
   * Returns the employee ID.
   */
   public String getEmployeeID()
   {
      return employeeID;
   }

   /**
   * Sets the employee ID.
   * @param employeeID the employee ID.
   */
   public void setEmployeeID(String employeeID)
   {
      this.employeeID = employeeID;
   }

   /**
   * Returns the employee name.
   */
   public String getName()
   {
      return name;
   }

   /**
   * Sets the employee name.
   * @param name the employee name.
   */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
   * Returns the dateHired.
   */
   public Date getDateHired()
   {
      return dateHired;
   }

   /**
   * Sets the dateHired.
   * @param dateHired the dateHired.
   */
   public void setDateHired(Date dateHired)
   {
      this.dateHired = dateHired;
   }

   /**
   * Returns the isManager flag.
   */
   public boolean getIsManager()
   {
      return isManager;
   }

   /**
   * Sets the isManager flag.
   * @param isManager the isManager flag.
   */
   public void setIsManager(boolean isManager)
   {
      this.isManager = isManager;
   }

   /**
   * Returns the department ID.
   */
   public String getDepartmentID()
   {
      return departmentID;
   }

   /**
   * Sets the department ID.
   * @param departmentID the department ID.
   */
   public void setDepartmentID(String departmentID)
   {
      this.departmentID = departmentID;
   }

   /**
   * Returns the title.
   */
   public String getTitle()
   {
      return title;
   }

   /**
   * Sets the title.
   * @param title the title.
   */
   public void setTitle(String title)
   {
      this.title = title;
   }

   /**
   * Returns the email.
   */
   public String getEmail()
   {
      return email;
   }

   /**
   * Sets the email.
   * @param email the email.
   */
   public void setEmail(String email)
   {
      this.email = email;
   }

   /**
   * Returns the phone.
   */
   public String getPhone()
   {
      return phone;
   }

   /**
   * Sets the phone.
   * @param phone the phone.
   */
   public void setPhone(String phone)
   {
      this.phone = phone;
   }
}
