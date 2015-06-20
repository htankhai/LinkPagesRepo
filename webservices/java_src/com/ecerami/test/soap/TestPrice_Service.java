package com.ecerami.test.soap;

import junit.framework.*;
import com.ecerami.soap.*;

public class TestPrice_Service extends TestCase {

     public TestPrice_Service (String name) {
         super(name);
     }

    /**
     * Tests Price Service
     */
    public void testPriceService () throws Exception {
      PriceClient client = new PriceClient();
      double price = client.getPrice("A358565");
      assertEquals (19.99, price, 0.0);
    }

}