package com.ecerami.test.soap;

import junit.framework.*;
import com.ecerami.soap.*;

public class TestHello_Service extends TestCase {

     public TestHello_Service (String name) {
         super(name);
     }

    /**
     * Tests Hello Service
     */
    public void testHello () throws Exception {
      HelloClient client = new HelloClient();
      String greeting = client.getGreeting("Amy");
      assertEquals ("Hello, Amy!", greeting);
    }

}