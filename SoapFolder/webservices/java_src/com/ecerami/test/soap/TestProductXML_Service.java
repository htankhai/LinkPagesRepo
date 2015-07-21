package com.ecerami.test.soap;

import junit.framework.*;
import org.w3c.dom.*;
import com.ecerami.soap.*;
import org.apache.soap.util.xml.XMLParserUtils;
import org.apache.soap.util.xml.DOM2Writer;

public class TestProductXML_Service extends TestCase {

     public TestProductXML_Service (String name) {
         super(name);
     }

    /**
     * Tests Product Service
     */
    public void testProductXML () throws Exception {
      ProductXMLClient client = new ProductXMLClient();
      Element product = client.getProduct("A358185");
      DOM2Writer domWriter = new DOM2Writer();
      String xml = domWriter.nodeToString(product);
      assertEquals ("<product sku=\"A358185\"><name>Red Hat Linux</name>"+
        "<description>Red Hat Linux Operating System</description><price>54.99</price></product>",
        xml);
    }

}