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
 * Provides Product Information for requested Stockkeeping Unit (SKU)
 */
public class ProductService {
  protected Hashtable products;   // Product "Database"

  /**
   * Constructor
   * Load product database with two sample products
   */
  public ProductService () {
    products = new Hashtable();
    ProductBean product1 = new ProductBean
      ("Red Hat Linux", "Red Hat Linux Operating System",
      54.99, "A358185");
    ProductBean product2 = new ProductBean
      ("McAfee PGP", "McAfee PGP Personal Privacy",
      19.99, "A358565");
    products.put(product1.getSKU(), product1);
    products.put(product2.getSKU(), product2);
  }

  /**
  *  Provides Product Info. for requested SKU.
  *  We assume that the client always specifies a valid, current SKU
  */
  public ProductBean getProduct (String sku) {
    ProductBean product = (ProductBean) products.get(sku);
    return product;
  }
}