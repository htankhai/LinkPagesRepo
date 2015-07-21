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
 * Retrieves Current Price for Specified Stockkeeping Unit (SKU)
 * Program illustrates different fault handling techniques.
 * usage:  java PriceClient sku#
*/
import java.net.*;
import java.util.Vector;
import org.apache.soap.SOAPException;
import org.apache.soap.Fault;
import org.apache.soap.Constants;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;
import org.w3c.dom.Element;
import org.apache.soap.util.xml.DOMUtils;

public class PriceClient {

  /**
   * Static Main method
   */
  public static void main (String[] args) {
    String sku = args[0];
    System.out.println ("Price Checker:  SOAP Client");
    PriceClient priceClient = new PriceClient();
    try {
      double price = priceClient.getPrice(sku);
      System.out.println ("SKU:  "+sku+" -->  "+price);
    } catch (ProductNotFoundException e) {
      System.err.println (e);
      printFaultDetails (e.getFault());
    } catch (SOAPException e) {
      System.err.println (e);
    } catch (MalformedURLException e) {
      System.err.println (e);
    }
  }

  /**
   * Extract and Print Fault Details
   */
  public static void printFaultDetails (Fault fault) {
    // Extract Detail Entries
    Vector detailEntries = fault.getDetailEntries();
    if (detailEntries != null) {
      // Print each Detail Entry
     for (int i=0; i< detailEntries.size(); i++) {
        Element detail = (Element) detailEntries.elementAt(i);
        String name = detail.getNodeName();
        String value = DOMUtils.getChildCharacterData(detail);
        System.err.println (name);
        System.err.println (value);
      }
    }
  }
  /**
   * getPrice Method
  */
  public double getPrice (String sku)
    throws SOAPException, MalformedURLException,
    ProductNotFoundException {
    Parameter skuParam;

    //  Create SOAP RPC Call Object
    Call call = new Call ();

    // Set Encoding Style to standard SOAP encoding
    call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);

    // Set Object URI and Method Name
    call.setTargetObjectURI ("urn:examples:priceservice");
    call.setMethodName ("getPrice");

    //  Set Method Parameters
    Vector paramList = new Vector ();
    skuParam = new Parameter("sku", String.class,
      sku, Constants.NS_URI_SOAP_ENC);
    paramList.addElement (skuParam);

    call.setParams (paramList);

    //  Set the URL for the Web Service
    URL url = new URL ("http://localhost:8080/soap/servlet/rpcrouter");

    // Invoke the Service
    Response resp = call.invoke (url, "");

    // Check for Success
    // Note that a Fault will not trigger a SOAPException
    if (!resp.generatedFault()) {
      // Extract Return value
      Parameter result = resp.getReturnValue ();
      Double price = (Double) result.getValue();
      return price.doubleValue();
    }
    //  Check for Faults
    else {
        //  Extract Fault Code and throw new Exception
        Fault fault = resp.getFault();
        String faultString = fault.getFaultString();
        throw new ProductNotFoundException (faultString, fault);
    }
  }
}