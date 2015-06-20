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
 * Data is returned as an XML Literal Document
 * usage:  java ProductXMLClient sku#
*/
import java.net.*;
import java.util.Vector;
import org.w3c.dom.*;
import org.apache.soap.*;
import org.apache.soap.rpc.*;
import javax.xml.parsers.DocumentBuilder;
import org.apache.soap.util.xml.XMLParserUtils;
import org.apache.soap.util.xml.DOM2Writer;

public class ProductXMLClient {

  /**
   * Static Main method
   */
  public static void main (String[] args) {
    String sku = args[0];
    System.out.println ("XML Product Checker:  SOAP Client");
    ProductXMLClient productXMLClient = new ProductXMLClient();
    try {
      Element product = productXMLClient.getProduct (sku);
      DOM2Writer domWriter = new DOM2Writer();
      System.out.println ("Server Response:  ");
      System.out.println (domWriter.nodeToString(product));
    } catch (SOAPException e) {
      System.err.println (e);
    } catch (MalformedURLException e) {
      System.err.println (e);
    }
  }

  /**
   * getProduct Method
  */
  public Element getProduct (String sku)
    throws SOAPException, MalformedURLException {
    Parameter skuParam;

    //  Create SOAP RPC Call Object
    Call call = new Call ();

    // Set Encoding Style to XML Literal
    call.setEncodingStyleURI(Constants.NS_URI_LITERAL_XML);

    // Set Object URI and Method Name
    call.setTargetObjectURI ("urn:examples:XMLproductservice");
    call.setMethodName ("getProduct");

    //  Set Method Parameters
    Vector paramList = new Vector ();

    //  Create XML Document to store SKU
    DocumentBuilder docBuilder = XMLParserUtils.getXMLDocBuilder();
    Document doc = docBuilder.newDocument();

    // Create product element with sku attribute
    Element productNode = doc.createElement("product");
    productNode.setAttribute("sku", sku);

    skuParam = new Parameter("productNode", org.w3c.dom.Element.class,
      productNode, Constants.NS_URI_LITERAL_XML);
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
      Element xmlResult = (Element) result.getValue();
      return xmlResult;
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