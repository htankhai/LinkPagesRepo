package com.ecerami.test.soap;

import junit.framework.*;
import com.ecerami.soap.*;

public class TestProduct_Service extends TestCase {

     public TestProduct_Service (String name) {
         super(name);
     }

    /**
     * Tests Product Service
     */
    public void testProductService () throws Exception {
      ProductClient client = new ProductClient();
      ProductBean product = client.getProduct("A358185");
      assertEquals ("Red Hat Linux", product.getName());
      assertEquals ("Red Hat Linux Operating System", product.getDescription());
      assertEquals (54.99, product.getPrice(), 0.0);
    }

}