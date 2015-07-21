/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.soap;

/**
 * A Sample SOAP Client
 * Retrieves Product Info for Specified Stockkeeping Unit (SKU)
 * usage:  java ProductClient sku#
*/
import java.net.*;
import java.util.Vector;
import org.apache.soap.*;
import org.apache.soap.rpc.*;
import org.apache.soap.encoding.soapenc.BeanSerializer;
import org.apache.soap.encoding.SOAPMappingRegistry;
import org.apache.soap.util.xml.QName;

public class ProductClient {

  /**
   * Static Main method
   */
  public static void main (String[] args) {
    String sku = args[0];
    System.out.println ("Product Checker:  SOAP Client");
    ProductClient productClient = new ProductClient();
    try {
      ProductBean product = productClient.getProduct (sku);
      System.out.println ("SKU:  "+product.getSKU());
      System.out.println ("Name:  "+product.getName());
      System.out.println ("Description:  "+product.getDescription());
      System.out.println ("Price:  "+product.getPrice());
    } catch (SOAPException e) {
      System.err.println (e);
    } catch (MalformedURLException e) {
      System.err.println (e);
    }
  }

  /**
   * getProduct Method
  */
  public ProductBean getProduct (String sku)
    throws SOAPException, MalformedURLException {
    Parameter skuParam;

    //  Create SOAP RPC Call Object
    Call call = new Call ();

    // Set Encoding Style to standard SOAP encoding
    call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);

    // Set Object URI and Method Name
    call.setTargetObjectURI ("urn:examples:productservice");
    call.setMethodName ("getProduct");

    //  Add JavaXML Mapping for Product Bean
    //  First, Create a Bean Serializer
    BeanSerializer bSerializer = new BeanSerializer();

    //  Second, Get the current SOAPMappingRegistry
    //  This object is pre-registered with basic mappings
    SOAPMappingRegistry registry = new SOAPMappingRegistry();

    //  Third, Create an new Qualified Namespace for Product Bean
    QName qname = new QName ("urn:examples", "product");

    //  Fourth, Register new mapping for ProductBean
    registry.mapTypes (Constants.NS_URI_SOAP_ENC, qname,
      com.ecerami.soap.ProductBean.class, bSerializer,
      bSerializer);

    //  Fifth, Set MappingRegistry for the Call object
    call.setSOAPMappingRegistry(registry);

    //  Set Method Parameters
    Vector paramList = new Vector ();
    skuParam = new Parameter("sku", String.class,
      sku, Constants.NS_URI_SOAP_ENC);
    paramList.addElement (skuParam);
    call.setParams (paramList);

    //  Set the URL for the Web Service
    URL url = new URL ("http://localhost:8080/soap/servlet/rpcrouter");

    // Invoke the Service
    Response resp = call.invoke (url, null);

    // Check for Success
    if (!resp.generatedFault()) {
      // Extract Return value
      Parameter result = resp.getReturnValue ();
      ProductBean product = (ProductBean) result.getValue();
      return product;
    }
    //  Check for Faults
    else {
      //  Extract Fault Code and String
      Fault f = resp.getFault();
      String faultCode = f.getFaultCode();
      String faultString = f.getFaultString();
      System.err.println("Fault Occurred (details follow):");
      System.err.println("Fault Code:  "+faultCode);
      System.err.println("Fault String:  "+faultString);
      return null;
    }
  }
}