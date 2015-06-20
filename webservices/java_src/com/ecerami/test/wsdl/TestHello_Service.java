package com.ecerami.test.wsdl;

import junit.framework.*;
import com.ecerami.wsdl.*;

public class TestHello_Service extends TestCase {

     public TestHello_Service (String name) {
         super(name);
     }

    /**
     * Tests Weather Retrieval Via GLUE Interface
     */
    public void testHello () throws Exception {
      Invoke_Hello invoker = new Invoke_Hello();
      String greeting = invoker.sayHello("World");
      assertEquals ("Hello, World!", greeting);
    }

}