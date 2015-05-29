package org.JAX_WS;

//package com.nb.beginjava6.service; 
import javax.jws.WebMethod; 
import javax.jws.WebService; 
import javax.jws.soap.SOAPBinding;
//import com.nb.beginjava6.service.bean.OrderBean; 

//JWS annotation that specifies that the port Type name of the Web Service is 
//"OrderProcessPort", the service name is "OrderProcess", and the targetNamespace 
//used in the generated WSDL is "http://nb.com/beginjava6/orderprocess" 

@WebService(serviceName = "OrderProcess", portName = "OrderProcessPort",
targetNamespace = "http://nb.com/beginjava6/orderprocess") 

//JWS annotation that specifies the mapping of the service onto the SOAP message 
//protocol. In particular, it specifies that the SOAP messages are document-literal. 

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL) 

public class OrderProcessService { 
	@WebMethod public OrderBean processOrder(OrderBean orderBean) { 
		//Do processing... 
		System.out.println("processOrder called for customer" 
		+ orderBean.getCustomer().getCustomerId()); 
		//No of items ordered 
		System.out.println("Number of items is " + orderBean.getOrderItems().length); 
		//Process Order. //Set the Order Id.
		orderBean.setOrderId("A1234");
		
		return orderBean;
	}

}