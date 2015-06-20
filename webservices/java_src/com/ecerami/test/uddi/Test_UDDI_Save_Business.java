package com.ecerami.test.uddi;

import junit.framework.*;
import com.ecerami.uddi.*;
import java.util.*;
import com.ibm.uddi.UDDIException;
import com.ibm.uddi.client.UDDIProxy;
import com.ibm.uddi.response.*;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;

public class Test_UDDI_Save_Business extends TestCase {

     public Test_UDDI_Save_Business (String name) {
         super(name);
     }

    /**
     * Tests Save then Delete Business Service
     */
    public void test_Save_and_Delete_Business () throws Exception {
      boolean businessKeyFlag = false;

      //  First, save Business
      AuthToken token = UDDIUtil.get_authentication_token("cerami@cs.nyu.edu", "coldswan");;
      saveBusiness publish = new saveBusiness (token);
      String businessKey = publish.save_business();
      if (businessKey.length() > 0)
        businessKeyFlag = true;
      assertEquals (true, businessKeyFlag);

      //  Then, delete Business
      deleteBusiness publish2 = new deleteBusiness (token);
      DispositionReport dr = publish2.delete_business(businessKey);
      assertEquals ("E_success", dr.getErrCode());
    }

}