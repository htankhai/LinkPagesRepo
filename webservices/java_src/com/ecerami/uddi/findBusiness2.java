/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.uddi;

import java.util.*;
import com.ibm.uddi.client.UDDIProxy;
import com.ibm.uddi.UDDIException;
import com.ibm.uddi.util.*;
import com.ibm.uddi.response.DispositionReport;
import com.ibm.uddi.response.BusinessInfo;
import com.ibm.uddi.response.BusinessList;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;

public class findBusiness2 {
  private UDDIProxy proxy;

  /**
   * Main Method
   */
  public static void main (String args[]) {
      try {
        findBusiness2 inquiry = new findBusiness2();
        System.out.println ("Finding by D&B DUNS");
        BusinessList list = inquiry.find_by_D_and_B ("04-693-3052");
        inquiry.print_businesses (list);

        System.out.println ("Finding by NAICS");
        list = inquiry.find_by_NAICS("51121");
        inquiry.print_businesses(list);

        System.out.println ("Finding by Exact Name Search");
        list = inquiry.find_by_exact_name("Microsoft Corporation");
        inquiry.print_businesses (list);

      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (SOAPException e) {
        e.printStackTrace();
      } catch (UDDIException e) {
        //  Extract UDDI Disposition Report
        DispositionReport dr = e.getDispositionReport();
        if (dr!=null) {
          System.out.println("UDDIException faultCode:" + e.getFaultCode() +
            "\n errno:"    + dr.getErrno() +
            "\n errCode:"  + dr.getErrCode() +
            "\n errInfoText:" + dr.getErrInfoText());
        }
        e.printStackTrace();
        }
   }

   /**
    * Constructor
    */
   public findBusiness2 () throws MalformedURLException {
      proxy = new UDDIProxy();
      proxy.setInquiryURL("http://uddi.microsoft.com/inquire");
   }

  /**
    * Find by D&B DUNS Number
    * @param duns D&B DUNS Number
  */
  public BusinessList find_by_D_and_B (String duns)
    throws SOAPException, UDDIException {
    Vector keyedReferenceVector = new Vector();
    KeyedReference keyedRef = new KeyedReference
      ("dnb-com:D-U-N-S", duns);
    keyedRef.setTModelKey ("uuid:8609c81e-ee1f-4d5a-b202-3eb13ad01823");
    keyedReferenceVector.addElement (keyedRef);
    IdentifierBag idBag = new IdentifierBag ();
    idBag.setKeyedReferenceVector(keyedReferenceVector);

    //  Find Matching Businesses
    BusinessList bl = proxy.find_business(idBag, null, 0);
    return bl;
  }

  /**
   * Find by NAICS Code
   * @param naics NAICS Code
   */
  public BusinessList find_by_NAICS (String naics)
    throws SOAPException, UDDIException {
    Vector keyedReferenceVector = new Vector();
    KeyedReference keyedRef = new KeyedReference ("ntis-gov:naics:1997", naics);
    keyedRef.setTModelKey ("uuid:C0B9FE13-179F-413D-8A5B-5004DB8E5BB2");
    keyedReferenceVector.addElement (keyedRef);
    CategoryBag categoryBag = new CategoryBag ();
    categoryBag.setKeyedReferenceVector(keyedReferenceVector);
    BusinessList bl = proxy.find_business(categoryBag, null, 0);
    return bl;
  }

  /**
   * Find by Exact Name Match
   * Illustrates use of UDDI Find Qualifiers
   * @param businessName Business Name
   */
  public BusinessList find_by_exact_name (String businessName)
    throws SOAPException, UDDIException  {
    Vector fqs = new Vector();
    FindQualifiers findQualifiers = new FindQualifiers ();
    FindQualifier fq = new FindQualifier(FindQualifier.exactNameMatch);
    fqs.addElement(fq);
    findQualifiers.setFindQualifierVector(fqs);
    BusinessList list = proxy.find_business (businessName, findQualifiers, 0);
    return list;
  }

  /**
   * Print Business List
   * @param list Business List Object
   */
  public void print_businesses (BusinessList bl) {
    Vector businessInfoVector  = bl.getBusinessInfos().getBusinessInfoVector();
    // Print name and business key for each matching business
    for (int i = 0; i < businessInfoVector.size(); i++) {
        BusinessInfo businessInfo = (BusinessInfo)businessInfoVector.elementAt(i);
        String name = businessInfo.getNameString();
        String businessKey = businessInfo.getBusinessKey();
        System.out.println (name+":  "+businessKey);
    }
  }
}