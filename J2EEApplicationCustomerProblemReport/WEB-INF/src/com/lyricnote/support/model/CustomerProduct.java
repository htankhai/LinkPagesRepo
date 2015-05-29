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
* A customer/product pair whose existence indicates
* that the customer bought the specified product.
*/
public class CustomerProduct implements Serializable
{
   private String customerID;
   private String productID;
   private Date datePurchased;

   /**
   * Factory method to create a customer/product record
   * from the current row of a result set.
   * @param rs a result set from the customer table
   * @exception SQLException if a database error occurs
   */
   public static CustomerProduct load(ResultSet rs)
      throws SQLException
   {
      CustomerProduct custprod = new CustomerProduct();

      custprod.setCustomerID(rs.getString(1));
      custprod.setProductID(rs.getString(2));
      custprod.setDatePurchased(rs.getDate(3));

      return custprod;
   }

   /**
   * Returns the object as a CSV string
   */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();

      sb.append(getCustomerID());
      sb.append(",");
      sb.append(getProductID());
      sb.append(",");
      sb.append(Model.formatDate(getDatePurchased()));

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
   * Returns the datePurchased.
   */
   public Date getDatePurchased()
   {
      return datePurchased;
   }

   /**
   * Sets the datePurchased.
   * @param datePurchased the datePurchased.
   */
   public void setDatePurchased(Date datePurchased)
   {
      this.datePurchased = datePurchased;
   }

}
