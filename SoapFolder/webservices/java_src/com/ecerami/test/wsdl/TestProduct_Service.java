package com.ecerami.test.wsdl;

import junit.framework.*;
import com.ecerami.wsdl.*;
import com.ecerami.wsdl.glue.*;

public class TestProduct_Service extends TestCase {

     public TestProduct_Service (String name) {
         super(name);
     }

    /**
     * Tests Product Retrieval Via GLUE Interface
     */
    public void testProductRetrieval () throws Exception {
      Invoke_Product invoker = new Invoke_Product();
      product prod = invoker.getProduct("A358185");
      assertEquals ("Red Hat Linux", prod.name);
      assertEquals ("Red Hat Linux Operating System", prod.description);
      assertEquals (54.99, prod.price, 0.0);
    }

}