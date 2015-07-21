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
 * Retrieves Current Counter value from CounterService
 * Illustrates Session v. Application Scope
*/
import java.util.*;
import java.net.*;
import org.apache.soap.*;
import org.apache.soap.rpc.*;

public class CounterClient {
  private Call call;   // Reusable Call Object

  /**
   * Static Main method
   */
  public static void main (String[] args) {
    System.out.println ("Session/Application Counter:  SOAP Client");
    CounterClient counterClient = new CounterClient();
    counterClient.process();
  }

  /**
   * Constructor
   * Create reusable Call object
   */
  public CounterClient () {
    call = new Call();
  }

  /**
   * Start counting
   */
  public void process () {
    try {
      for (int i=0; i<5; i++) {
        int counter = getCounter ();
        System.out.println ("Counter:  "+counter);
      }
    } catch (CounterException e) {
      System.err.println (e);
    } catch (SOAPException e) {
      System.err.println (e);
    } catch (MalformedURLException e) {
      System.err.println (e);
    }
  }

  /**
   * getCounter Method
  */
  public int getCounter ()
    throws SOAPException, MalformedURLException,
    CounterException {

    // Set Encoding Style to standard SOAP encoding
    call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);

    // Set Object URI and Method Name
    call.setTargetObjectURI ("urn:examples:counterservice");
    call.setMethodName ("getCounter");

    //  Set the URL for the Web Service
    URL url = new URL ("http://localhost:8080/soap/servlet/rpcrouter");

    // Invoke the Service
    Response resp = call.invoke (url, null);

    // Check for Success
    if (!resp.generatedFault()) {
      // Extract Return value
      Parameter result = resp.getReturnValue ();
      Integer counter = (Integer) result.getValue();
      return counter.intValue();
    }
    //  Check for Faults
    else {
        //  Extract Fault Code and String
        Fault f = resp.getFault();
        String faultCode = f.getFaultCode();
        String faultString = f.getFaultString();
        throw new CounterException (faultCode+": "+faultString);
    }
  }

  /**
  * CounterException
  * Encapsulates any exceptions related to retrieving
  * application/session counter.
  */
  class CounterException extends Exception {
    private String msg;

    public CounterException (String msg) {
      super(msg);
    }
  }
}