/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.soap;

import java.util.Hashtable;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import org.apache.soap.util.xml.XMLParserUtils;

/**
 * A Sample SOAP Service
 * Provides Product Name for requested Stockkeeping Unit (SKU)
 * Information is passed as Literal XML Documents.
 */
public class ProductXMLService extends ProductService{

  /**
  *  Provides Product Info. for requested XML document.
  */
  public Element getProduct (Element request)
    throws ProductNotFoundException {
    //  Extract sku attribute
    String sku = request.getAttribute("sku");
    ProductBean product = (ProductBean) products.get(sku);

    //  Create XML Document to store Product data
    DocumentBuilder docBuilder = XMLParserUtils.getXMLDocBuilder();
    Document doc = docBuilder.newDocument();

    //  Create Product Name Element
    Text productNameText = doc.createTextNode(product.getName());
    Element nameNode = doc.createElement("name");
    nameNode.appendChild(productNameText);

    //  Create Product Description Element
    Text productDescriptionText =
      doc.createTextNode(product.getDescription());
    Element descriptionNode = doc.createElement("description");
    descriptionNode.appendChild(productDescriptionText);

    //  Create Product Name Element
    Text productPriceText = doc.createTextNode(
      Double.toString(product.getPrice()));
    Element priceNode = doc.createElement("price");
    priceNode.appendChild(productPriceText);

    // Create Root Product Element
    Element productNode = doc.createElement("product");
    productNode.setAttribute("sku", sku);
    productNode.appendChild(nameNode);
    productNode.appendChild(descriptionNode);
    productNode.appendChild(priceNode);
    return productNode;
  }
}