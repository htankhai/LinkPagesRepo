package org.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//Client
//JAXB. Annotation. RootElement and propOrder.

@XmlRootElement(name="Product")
@XmlType(propOrder={"price" ,"sku", "name"})
public class Product 
{
	public String name;
	public String sku;
	public double price;
	
	//Conversion of Java to Xml//JABX
	public Product(){
	
	}

	public Product(String name, String sku, double price){
		this.name = name;
		this.sku = sku;
		this.price = price;
	}

	public void setName ( String name) {
		this.name = name;
	}

	@XmlElement(name="ProductName")
	public String getName(){
		return name;
	}

	public void setSku(String sku){
		this.sku = sku;
	}

	public String getSku(){
		return sku;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}
}
