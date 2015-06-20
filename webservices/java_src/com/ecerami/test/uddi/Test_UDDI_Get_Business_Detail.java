package com.ecerami.test.uddi;

import junit.framework.*;
import com.ecerami.uddi.*;
import java.util.*;
import com.ibm.uddi.UDDIException;
import com.ibm.uddi.client.UDDIProxy;
import com.ibm.uddi.response.*;
import com.ibm.uddi.datatype.business.*;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;

public class Test_UDDI_Get_Business_Detail extends TestCase {

     public Test_UDDI_Get_Business_Detail (String name) {
         super(name);
     }

    /**
     * Tests Get Business Detail
     */
    public void testGetBusinessDetail () throws Exception {
      getBusinessDetail inquiry = new getBusinessDetail();;
      BusinessDetail businessDetail = inquiry.getBusinessDetail("0076b468-eb27-42e5-ac09-9955cff462a3");
      Vector businessEntityVector = businessDetail.getBusinessEntityVector();
      for (int i=0; i<businessEntityVector.size(); i++) {
        BusinessEntity businessEntity =
          (BusinessEntity) businessEntityVector.elementAt(i);
        String name = businessEntity.getNameString();
        String description = businessEntity.getDefaultDescriptionString();
        if (i==0) {
          assertEquals ("Microsoft Corporation", name);
          assertEquals ("Empowering people through great software - "+
            "any time, any place and on any device is Microsofts vision. "+
            "As the worldwide leader in software for personal and business "+
            "computing, we strive to produce innovative products and services "+
            "that meet our customer's", description);
        }
      }
  }
}