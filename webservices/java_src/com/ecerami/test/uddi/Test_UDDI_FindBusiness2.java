package com.ecerami.test.uddi;

import junit.framework.*;
import com.ecerami.uddi.*;
import java.util.*;
import com.ibm.uddi.UDDIException;
import com.ibm.uddi.client.UDDIProxy;
import com.ibm.uddi.response.*;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;

public class Test_UDDI_FindBusiness2 extends TestCase {

     public Test_UDDI_FindBusiness2 (String name) {
         super(name);
     }

    /**
     * Tests Find Business Service
     */
    public void test_D_B_Search () throws Exception {
      findBusiness2 inquiry = new findBusiness2();
      BusinessList list = inquiry.find_by_D_and_B("04-693-3052");

      Vector businessInfoVector  = list.getBusinessInfos().getBusinessInfoVector();
      for (int i = 0; i < businessInfoVector.size(); i++) {
        BusinessInfo businessInfo = (BusinessInfo)businessInfoVector.elementAt(i);
        String name = businessInfo.getNameString();
        String businessKey = businessInfo.getBusinessKey();
        if (i==0) {
          assertEquals ("Mediaplex", name);
          assertEquals ("572d585f-b663-46f5-ad68-c9b871d7b8df", businessKey);
        }
      }
    }

    public void test_NAICS_Search () throws Exception {
      findBusiness2 inquiry = new findBusiness2();
      BusinessList list = inquiry.find_by_NAICS ("51121");

      Vector businessInfoVector  = list.getBusinessInfos().getBusinessInfoVector();
      boolean found = false;
      for (int i = 0; i < businessInfoVector.size(); i++) {
        BusinessInfo businessInfo = (BusinessInfo)businessInfoVector.elementAt(i);
        String name = businessInfo.getNameString();
        String businessKey = businessInfo.getBusinessKey();
        if (name.startsWith ("Oracle Corporation"))
          found = true;
      }
      assertEquals (true, found);
    }

    public void test_exact_match () throws Exception {
      findBusiness2 inquiry = new findBusiness2();
      BusinessList list = inquiry.find_by_exact_name("Microsoft Corporation");

      Vector businessInfoVector  = list.getBusinessInfos().getBusinessInfoVector();
      for (int i = 0; i < businessInfoVector.size(); i++) {
        BusinessInfo businessInfo = (BusinessInfo)businessInfoVector.elementAt(i);
        String name = businessInfo.getNameString();
        String businessKey = businessInfo.getBusinessKey();
        if (i==0) {
          assertEquals ("Microsoft Corporation", name);
          assertEquals ("0076b468-eb27-42e5-ac09-9955cff462a3", businessKey);
        }
      }
    }

}