/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.soap;

/**
 * A Product Bean
 * Encapsulates data regarding one product
*/

public class ProductBean {
  private String name;          //  Product Name
  private String description;   //  Product Description
  private double price;         //  Product Price
  private String sku;           //  Product SKU

  /**
   * Zero-argument Constructor
   */
  public ProductBean () { }

  /**
   * Constructor with full arguments
   */
  public ProductBean (String name, String description, double price,
    String sku) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.sku = sku;
  }

  //  Setters
  public void setName (String name) {
    this.name = name;
  }

  public void setDescription (String description) {
      this.description = description;
  }

  public void setPrice (double price) {
    this.price = price;
  }

  public void setSKU (String sku) {
    this.sku = sku;
  }

  //  Getters
  public String getName () { return name; }
  public String getDescription () { return description; }
  public double getPrice () { return price; }
  public String getSKU () { return sku; }
}