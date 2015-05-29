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
* A software product supported by the Product
* Support system.
*/
public class Product implements Serializable
{
   private String productID;
   private String name;
   private String productSupport;
   private String developer;
   private String tester;

   /**
   * Factory method to create a product record
   * from the current row of a result set.
   * @param rs a result set from the product table
   * @exception SQLException if a database error occurs
   */
   public static Product load(ResultSet rs)
      throws SQLException
   {
      Product product = new Product();
      String value = null;

      value = rs.getString(1);
      if (value != null)
         product.setProductID(value);

      value = rs.getString(2);
      if (value != null)
         product.setName(value);

      value = rs.getString(3);
      if (value != null)
         product.setProductSupport(value);

      value = rs.getString(4);
      if (value != null)
         product.setDeveloper(value);

      value = rs.getString(5);
      if (value != null)
         product.setTester(value);

      return product;
   }

   /**
   * Returns the object as a CSV string
   */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();

      if (getProductID() != null)
         sb.append(Model.quote(getProductID()));

      sb.append(",");
      if (getName() != null)
         sb.append(Model.quote(getName()));

      sb.append(",");
      if (getProductSupport() != null)
         sb.append(Model.quote(getProductSupport()));

      sb.append(",");
      if (getDeveloper() != null)
         sb.append(Model.quote(getDeveloper()));

      sb.append(",");
      if (getTester() != null)
         sb.append(Model.quote(getTester()));

      return sb.toString();
   }

   // ===========================================
   //    Property accessor methods
   // ===========================================

   /**
   * Returns the product ID.
   */
   public String getProductID()
   {
      return productID;
   }

   /**
   * Sets the product ID.
   * @param product the product ID.
   */
   public void setProductID(String productID)
   {
      this.productID = productID;
   }

   /**
   * Returns the product name.
   */
   public String getName()
   {
      return name;
   }

   /**
   * Sets the product name.
   * @param name the product name.
   */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
   * Returns the productSupport ID.
   */
   public String getProductSupport()
   {
      return productSupport;
   }

   /**
   * Sets the productSupport ID.
   * @param productSupport the productSupport.
   */
   public void setProductSupport(String productSupport)
   {
      this.productSupport = productSupport;
   }

   /**
   * Returns the developer.
   */
   public String getDeveloper()
   {
      return developer;
   }

   /**
   * Sets the developer.
   * @param developer the developer.
   */
   public void setDeveloper(String developer)
   {
      this.developer = developer;
   }

   /**
   * Returns the tester.
   */
   public String getTester()
   {
      return tester;
   }

   /**
   * Sets the tester.
   * @param tester the tester.
   */
   public void setTester(String tester)
   {
      this.tester = tester;
   }
}
