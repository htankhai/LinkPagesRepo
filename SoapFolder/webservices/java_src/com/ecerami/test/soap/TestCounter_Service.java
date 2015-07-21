package com.ecerami.test.soap;

import junit.framework.*;
import com.ecerami.soap.*;

public class TestCounter_Service extends TestCase {

     public TestCounter_Service (String name) {
         super(name);
     }

    /**
     * Tests Product Service
     */
    public void testCounter () throws Exception {
      CounterClient client = new CounterClient();
      int counter = client.getCounter();
      assertEquals (1, counter);
      counter = client.getCounter();
      assertEquals (2, counter);
    }

}