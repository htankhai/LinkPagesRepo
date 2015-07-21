/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.wsdl;

import java.io.IOException;
import electric.xml.io.Mappings;
import electric.xml.ParseException;
import electric.registry.RegistryException;
import com.ecerami.wsdl.glue.*;

/**
 * SOAP Invoker.  Uses the Product_ServiceHelper to invoke the Product
 * SOAP service.  All other .java files are automatically generated 
 * by GLUE.
*/
public class Invoke_Product {

  /**
   * Get Product via SOAP Service
   */
  public product getProduct (String sku) throws Exception {
    //  Load Java <--> XML Mapping
    Mappings.readMappings("Product_Service.map");
    //  Invoke Service
    IProduct_Service service = Product_ServiceHelper.bind();
    product prod = service.getProduct(sku);
    return prod;
  }

  /**
   * Main Method
   */
  public static void main (String[] args) throws Exception {
    Invoke_Product invoker = new Invoke_Product();
    System.out.println ("Product Service");
    product prod = invoker.getProduct("A358185");
    System.out.println ("Name:  "+prod.name);
    System.out.println ("Description:  "+prod.description);
    System.out.println ("Price:  "+prod.price);
 }
}
