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
public class ProductService2 extends ProductService {

  /**
  *  Provides Product Info. for requested SKU.
  *  If SKU is not found, method throws a ProductNotFoundException
  */
  public ProductBean getProductInfo (String sku)
    throws ProductNotFoundException {
    ProductBean product = (ProductBean) products.get(sku);
    if (product==null)
      throw new ProductNotFoundException ("SKU Not Found:  "+sku);
    return product;
  }
}