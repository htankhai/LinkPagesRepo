package com.ecerami.test;

import junit.framework.*;
import com.ecerami.wsdl.*;
import com.ecerami.test.wsdl.*;
import com.ecerami.test.soap.*;

public class MasterTest extends TestCase{

  public MasterTest (String name) {
    super (name);
  }

  public static Test suite () {
    TestSuite suite = new TestSuite();

    //  Run all XML-RPC Tests
    suite.addTest (new TestSuite (com.ecerami.test.xmlrpc.TestArea_Service.class));

    //  Run all SOAP Tests
    suite.addTest (new TestSuite (com.ecerami.test.soap.TestHello_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.soap.TestPrice_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.soap.TestPriceList_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.soap.TestProduct_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.soap.TestProductXML_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.soap.TestCounter_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.soap.TestProduct2_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.soap.TestWeather_Service.class));

    //  Run all WSDL Tests
    suite.addTest (new TestSuite (com.ecerami.test.wsdl.TestProduct_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.wsdl.TestHello_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.wsdl.TestPriceList_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.wsdl.TestPriceList_Service.class));
    suite.addTest (new TestSuite (com.ecerami.test.wsdl.TestWeather_Service.class));

    //  Run all UDDI Tests
    suite.addTest (new TestSuite (com.ecerami.test.uddi.Test_UDDI_FindBusiness.class));
    suite.addTest (new TestSuite (com.ecerami.test.uddi.Test_UDDI_FindBusiness2.class));
    suite.addTest (new TestSuite (com.ecerami.test.uddi.Test_UDDI_Get_Business_Detail.class));
    suite.addTest (new TestSuite (com.ecerami.test.uddi.Test_UDDI_Save_Business.class));
    return suite;
  }

  public static void main (String[] args) {
    junit.textui.TestRunner.run(MasterTest.suite());
    //junit.swingui.TestRunner.run(MasterTest.class);
  }

}