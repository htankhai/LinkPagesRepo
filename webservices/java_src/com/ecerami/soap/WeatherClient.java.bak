/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.soap;

/**
 * Weather SOAP Client
 * usage:  java WeatherClient
*/
import java.net.*;
import java.util.Vector;
import org.apache.soap.SOAPException;
import org.apache.soap.Fault;
import org.apache.soap.Constants;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;

public class WeatherClient {

  /**
   * Static Main method
   */
  public static void main (String[] args) {
    String firstName = args[0];
    System.out.println ("Weather SOAP Client");
    WeatherClient client = new WeatherClient();
    try {
      int temperature = client.getWeather ("10016");
      System.out.print ("Temperature:  "+temperature);
    } catch (SOAPException e) {
      String faultCode = e.getFaultCode();
      String faultMsg = e.getMessage();
      System.err.println ("SOAPException Thrown (details below):");
      System.err.println ("FaultCode:  "+faultCode);
      System.err.println ("FaultMessage:  "+faultMsg);
    } catch (MalformedURLException e) {
      System.err.println (e);
    }
  }

  /**
   * getWeather Method
  */
  public int getWeather (String zipcode)
    throws SOAPException, MalformedURLException {

    //  Create SOAP RPC Call Object
    Call call = new Call ();

    // Set Encoding Style to standard SOAP encoding
    call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);

    // Set Object URI and Method Name
    call.setTargetObjectURI ("urn:examples:weatherservice");
    call.setMethodName ("getWeather");

    //  Set Method Parameters
    Parameter param = new Parameter("zipcode", String.class,
      zipcode, Constants.NS_URI_SOAP_ENC);

    Vector paramList = new Vector ();
    paramList.addElement (param);
    call.setParams (paramList);

    //  Set the URL for the Web Service
    URL url = new URL ("http://localhost:8080/soap/servlet/rpcrouter");

    // Invoke the Service
    Response resp = call.invoke (url, "");

    // Check for Faults
    if (!resp.generatedFault()) {
      // Extract Return value
      Parameter result = resp.getReturnValue ();
      Integer temperature = (Integer) result.getValue();
      return temperature.intValue();
    }
    else {
      //  Extract Fault Code and String
      Fault f = resp.getFault();
      String faultCode = f.getFaultCode();
      String faultString = f.getFaultString();
      System.err.println("Fault Occurred (details follow):");
      System.err.println("Fault Code:  "+faultCode);
      System.err.println("Fault String:  "+faultString);
      return -999;
    }
  }
}