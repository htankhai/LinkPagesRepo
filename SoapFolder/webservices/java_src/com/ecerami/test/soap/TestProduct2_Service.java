package com.ecerami.test.soap;

import junit.framework.*;
import org.w3c.dom.*;
import com.ecerami.soap.*;
import org.apache.soap.util.xml.XMLParserUtils;
import org.apache.soap.util.xml.DOM2Writer;

public class TestProduct2_Service extends TestCase {

     public TestProduct2_Service (String name) {
         super(name);
     }

    /**
     * Tests Product Service
     */
    public void testProduct2 () throws Exception {
      ProductClient2 client = new ProductClient2();
      ProductBean product = client.getProduct("A358185");
      assertEquals ("Red Hat Linux", product.getName());
      assertEquals ("Red Hat Linux Operating System", product.getDescription());
      assertEquals (54.99, product.getPrice(), 0.0);

      try {
        product = client.getProduct("AA");
        fail ("ProductException should have been thrown.");
      } catch (ProductNotFoundException e) {
      }
    }

}