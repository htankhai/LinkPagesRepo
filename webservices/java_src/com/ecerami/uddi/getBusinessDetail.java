/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.uddi;

/**
 * Sample UDDI Program:  retrieves the businessEntity
 * specified by the first command line argument.
 * Example usage:
 * java getBusinessDetail ba744ed0-3aaf-11d5-80dc-002035229c64
 */
import java.util.*;
import com.ibm.uddi.client.UDDIProxy;
import com.ibm.uddi.UDDIException;
import com.ibm.uddi.response.DispositionReport;
import com.ibm.uddi.response.BusinessDetail;
import com.ibm.uddi.datatype.business.*;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;

public class getBusinessDetail {

  /**
   * Main Method
   */
  public static void main (String args[]) {
    try {
      getBusinessDetail inquiry = new getBusinessDetail();
      BusinessDetail businessDetail = inquiry.getBusinessDetail (args[0]);
      inquiry.print_businessDetail (businessDetail);
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
   * Retreive Business Detail Record
   * @param businessKey UDDI Business Key
   * @return UDDI Business Detail record
   */
   public BusinessDetail getBusinessDetail (String businessKey)
    throws MalformedURLException, SOAPException, UDDIException {
    //  Create UDDI Proxy Object
    UDDIProxy proxy = new UDDIProxy();
    //  Point to Microsoft Inquiry URL
    proxy.setInquiryURL("http://uddi.microsoft.com/inquire");

    //  Retrieve BusinessDetail record
    BusinessDetail businessDetail = proxy.get_businessDetail(businessKey);
    return businessDetail;
  }

  /**
   * Print Business Entity Data
   * @param businessDetail UDDI Business Detail Record
   */
  private void print_businessDetail (BusinessDetail businessDetail) {
    Vector businessEntityVector = businessDetail.getBusinessEntityVector();
    for (int i = 0; i < businessEntityVector.size(); i++) {
        BusinessEntity businessEntity =
          (BusinessEntity) businessEntityVector.elementAt(i);
        String name = businessEntity.getNameString();
        String description = businessEntity.getDefaultDescriptionString();
        System.out.println ("Business Name:  "+name);
        System.out.println ("Description:  "+description);
        Contacts contacts = businessEntity.getContacts();
        print_contacts (contacts);
      }
  }

  /**
   * Print Contact Data
   * @param contacts UDDI Contacts Information
   */
  private void print_contacts (Contacts contacts) {
    Vector contactVector = contacts.getContactVector();
    for (int j=0; j< contactVector.size(); j++) {
      Contact contact = (Contact) contactVector.elementAt (j);
      String description = contact.getDefaultDescriptionString();
      Vector addressVector = contact.getAddressVector();
      Vector emailVector = contact.getEmailVector();
      System.out.println ("Contact:  "+ description);
      print_addressVector (addressVector);
      print_emailVector (emailVector);
    }
  }

  /**
   * Print Address Data
   * @param addressVector Vector of UDDI Address Records
   */
  private void print_addressVector (Vector addressVector) {
    for (int i=0; i< addressVector.size(); i++) {
      Address address = (Address) addressVector.elementAt(i);
      Vector addressLines = address.getAddressLineVector();
      for (int j=0; j<addressLines.size(); j++) {
        AddressLine addressLine = (AddressLine) addressLines.elementAt(j);
        String addressText = addressLine.getText();
        System.out.println("Address:  "+addressText);
      }
    }
  }

  /**
   * Print Email Data
   * @param emailVector Vector of UDDI Email Objects
   */
  private void print_emailVector (Vector emailVector) {
    for (int i=0; i< emailVector.size(); i++) {
      Email email = (Email) emailVector.elementAt(i);
      String emailText = email.getText();
      System.out.println ("Email:  "+emailText);
    }
  }
}