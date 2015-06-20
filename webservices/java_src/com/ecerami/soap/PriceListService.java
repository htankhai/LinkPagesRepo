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
 * Provides a Price List for specified list of SKUs
 */
public class PriceListService {
  protected Hashtable products;   // Product "Database"

  /**
   * Zero Argument Constructor
   * Load product database with two sample products
   */
  public PriceListService () {
    products = new Hashtable();
    //  Red Hat Linux
    products.put("A358185", new Double (54.99));
    //  McAfee PGP Personal Privacy
    products.put("A358565", new Double (19.99));
  }

  /**
  *  Provides Price List for specified SKUs.
  *  We assume that the client always specifies valid, current SKUs
  */
  public double[] getPriceList (String sku[]) {
    double prices[] = new double [sku.length];
    for (int i=0; i<sku.length; i++) {
      Double price = (Double) products.get(sku[i]);
      prices[i] = price.doubleValue();
    }
    return prices;
  }
}