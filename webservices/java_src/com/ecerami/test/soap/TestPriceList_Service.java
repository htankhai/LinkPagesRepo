package com.ecerami.test.soap;

import junit.framework.*;
import com.ecerami.soap.*;

public class TestPriceList_Service extends TestCase {

     public TestPriceList_Service (String name) {
         super(name);
     }

    /**
     * Tests PriceList Service
     */
    public void testPriceList () throws Exception {
      String skus[] = {"A358185", "A358565" };
      PriceListClient client = new PriceListClient();
      double[] prices = client.getPriceList(skus);
      assertEquals (54.99, prices[0], 0.0);
      assertEquals (19.99, prices[1], 0.0);
    }

}