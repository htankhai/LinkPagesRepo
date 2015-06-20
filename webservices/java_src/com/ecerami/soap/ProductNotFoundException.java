/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.soap;

import org.apache.soap.Fault;

/**
 * ProductNotFoundException
 * Encapsulates any exceptions related to retrieving
 * product/price for Specified Stockkeeping Unit (SKU)
*/
public class ProductNotFoundException extends Exception {
  private Fault fault;

  public ProductNotFoundException (String faultString) {
    super (faultString);
  }

  public ProductNotFoundException (String faultString, Fault fault) {
    super (faultString);
    this.fault = fault;
  }

  public Fault getFault () { return fault; }
}