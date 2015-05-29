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
* A person or company that has bought LyricNote products.
*/
public class Customer implements Serializable
{
   private String customerID;
   private String name;
   private String phone;

   /**
   * Factory method to create a customer record
   * from the current row of a result set.
   * @param rs a result set from the customer table
   * @exception SQLException if a database error occurs
   */
   public static Customer load(ResultSet rs)
      throws SQLException
   {
      Customer customer = new Customer();
      String value = null;

      value = rs.getString(1);
      if (value != null)
         customer.setCustomerID(value);

      value = rs.getString(2);
      if (value != null)
         customer.setName(value);

      value = rs.getString(3);
      if (value != null)
         customer.setPhone(value);

      return customer;
   }

   /**
   * Returns the object as a CSV string
   */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();

      if (getCustomerID() != null)
         sb.append(Model.quote(getCustomerID()));

      sb.append(",");
      if (getName() != null)
         sb.append(Model.quote(getName()));

      sb.append(",");
      if (getPhone() != null)
         sb.append(Model.quote(getPhone()));

      return sb.toString();
   }

   // ===========================================
   //    Property accessor methods
   // ===========================================

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
   * Returns the name.
   */
   public String getName()
   {
      return name;
   }

   /**
   * Sets the name.
   * @param name the name.
   */
   public void setName(String name)
   {
      this.name = name;
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
