/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.soap;

import java.util.Hashtable;
/**
 * A Sample SOAP Service
 * Provides Current Price for requested Stockkeeping Unit (SKU)
 */
public class PriceService {
  protected Hashtable products;

  /**
   * Zero Argument Constructor
   * Load product database with two sample products
   */
  public PriceService () {
    products = new Hashtable();
    //  Red Hat Linux
    products.put("A358185", new Double (54.99));
    //  McAfee PGP Personal Privacy
    products.put("A358565", new Double (19.99));
  }

  /**
  *  Provides Current Price for requested SKU
  *  In a real-setup, this method would connect to
  *  a price database.  If SKU is not found, method
  *  will throw a PriceException.
  */
  public double getPrice (String sku)
    throws ProductNotFoundException {
    Double price = (Double) products.get(sku);
    if (price == null) {
      throw new ProductNotFoundException ("SKU: "+sku+" not found");
    }
    return price.doubleValue();
  }
}