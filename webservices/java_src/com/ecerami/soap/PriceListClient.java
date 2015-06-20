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
 * Retrieves Price List for Specified SKUs
 * usage:  java PriceClient sku#1 sku#2 sku#N
*/
import java.net.*;
import java.util.Vector;
import org.apache.soap.*;
import org.apache.soap.rpc.*;

public class PriceListClient {

  /**
   * Static Main method
   */
  public static void main (String[] args) {
    System.out.println ("Price List Checker:  SOAP Client");
    String skus[] = new String [args.length];
    for (int i=0; i<args.length; i++)
      skus[i] = new String (args[i]);
    PriceListClient priceListClient = new PriceListClient();
    try {
      double price[] = priceListClient.getPriceList(skus);
      for (int i=0; i<price.length; i++) {
        System.out.print ("SKU:  "+skus[i]);
        System.out.println (" --> "+price[i]);
      }
    } catch (SOAPException e) {
      System.err.println (e);
    } catch (MalformedURLException e) {
      System.err.println (e);
    }
  }

  /**
   * getPriceList Method
  */
  public double[] getPriceList (String skus[])
    throws SOAPException, MalformedURLException {
    Parameter skuParam;

    //  Create SOAP RPC Call Object
    Call call = new Call ();

    // Set Encoding Style to standard SOAP encoding
    call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);

    // Set Object URI and Method Name
    call.setTargetObjectURI ("urn:examples:pricelistservice");
    call.setMethodName ("getPriceList");

    //  Set Method Parameters
    Vector paramList = new Vector ();
    Parameter param = new Parameter("sku", String[].class,
        skus, Constants.NS_URI_SOAP_ENC);
    paramList.addElement (param);
    call.setParams (paramList);

    //  Set the URL for the Web Service
    URL url = new URL ("http://localhost:8080/soap/servlet/rpcrouter");

    // Invoke the Service
    Response resp = call.invoke (url, null);

    // Check for Success
    if (!resp.generatedFault()) {
      // Extract Return value
      Parameter result = resp.getReturnValue ();
      double priceList[] = (double []) result.getValue();
      return priceList;
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