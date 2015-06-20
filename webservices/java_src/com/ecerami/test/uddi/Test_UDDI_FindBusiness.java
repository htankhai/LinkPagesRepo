package com.ecerami.test.uddi;

import junit.framework.*;
import com.ecerami.uddi.*;
import java.util.*;
import com.ibm.uddi.UDDIException;
import com.ibm.uddi.client.UDDIProxy;
import com.ibm.uddi.response.*;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;

public class Test_UDDI_FindBusiness extends TestCase {

     public Test_UDDI_FindBusiness (String name) {
         super(name);
     }

    /**
     * Tests Find Business Service
     */
    public void testFindBusiness () throws Exception {
      findBusiness inquiry = new findBusiness();
      Vector businessInfoVector = inquiry.findBusinessByName ("Microsoft");

      for (int i=0; i<businessInfoVector.size(); i++) {
          BusinessInfo businessInfo =
            (BusinessInfo) businessInfoVector.elementAt(i);
          String name = businessInfo.getNameString();
          String businessKey = businessInfo.getBusinessKey();
          if (i==0) {
            assertEquals ("Microsoft Corporation", name);
            assertEquals ("0076b468-eb27-42e5-ac09-9955cff462a3", businessKey);
          }
      }
    }

}