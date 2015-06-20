package com.ecerami.test.wsdl;

import junit.framework.*;
import com.ecerami.wsdl.*;
import com.ecerami.wsdl.glue.*;

public class TestPriceList_Service extends TestCase {

     public TestPriceList_Service (String name) {
         super(name);
     }

    /**
     * Tests Product Retrieval Via GLUE Interface
     */
    public void testProductRetrieval () throws Exception {
      Invoke_PriceList invoker = new Invoke_PriceList();
      String skus[] = {"A358185", "A358565" };
      double[] prices = invoker.getPrices (skus);
      assertEquals (54.99, prices[0], 0.0);
      assertEquals (19.99, prices[1], 0.0);
    }
}