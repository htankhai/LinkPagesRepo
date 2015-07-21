/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.uddi;

import java.util.*;
import com.ibm.uddi.UDDIException;
import com.ibm.uddi.client.UDDIProxy;
import com.ibm.uddi.response.*;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;

/**
 * Sample UDDI Program:  searches for all companies that
 * match the first command line argument.
 * Example usage:  java findBusiness XMethods
 */
public class findBusiness {

  /**
   *  Main method
  */
  public static void main (String args[]) {
    findBusiness inquiry = new findBusiness();

    try {
      //  Search for Specified Business Name
      String businessName = args[0];
      System.out.println ("Searching for Businesses:  "+businessName);
      Vector businessInfoVector = inquiry.findBusinessByName (businessName);

      // Print name and business key for each matching business
      for (int i=0; i<businessInfoVector.size(); i++) {
          BusinessInfo businessInfo =
            (BusinessInfo) businessInfoVector.elementAt(i);
          String name = businessInfo.getNameString();
          String businessKey = businessInfo.getBusinessKey();
          System.out.println (name+":  "+businessKey);
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (SOAPException e) {
      e.printStackTrace();
    } catch (UDDIException e) {
      //  Extract UDDI Disposition Report
      DispositionReport dr = e.getDispositionReport();
      if (dr!=null) {
        System.out.println("UDDIException faultCode:" +
          e.getFaultCode() +
          "\n errno:"    + dr.getErrno() +
          "\n errCode:"  + dr.getErrCode() +
          "\n errInfoText:" + dr.getErrInfoText());
      }
      e.printStackTrace();
    }
  }

  /**
   *  Find Business by Name
   *  @param businessName Business Name Target
   *  @return Vector of BusinessInfo objects
  */
  public Vector findBusinessByName (String businessName)
    throws MalformedURLException, SOAPException, UDDIException {
    //  Create UDDI Proxy Object
    UDDIProxy proxy = new UDDIProxy();

    //  Point to Microsoft Inquiry URL
    proxy.setInquiryURL("http://uddi.microsoft.com/inquire");

    //  Find Matching Businesses
    BusinessList businessList = proxy.find_business(businessName, null, 0);

    //  Process UDDI Response
    BusinessInfos businessInfos = businessList.getBusinessInfos();
    Vector businessInfoVector = businessInfos.getBusinessInfoVector();
    return businessInfoVector;
   }
}