package com.ecerami.test.xmlrpc;

import junit.framework.*;
import com.ecerami.xmlrpc.*;

public class TestArea_Service extends TestCase {

     public TestArea_Service (String name) {
         super(name);
     }

    /**
     * Tests XML-RPC Area Service
     */
    public void testArea () throws Exception {
      AreaClient client = new AreaClient();
      double area = client.areaCircle(4.0);
      assertEquals (50.265, area, .5);
    }

}