package org.publisher;
//publish WSDL
import javax.xml.ws.Endpoint;
import org.model.Product;
import org.webService.ProductCatalog;
public class DynWebServicesPublisher {
	public static void main(String[] args){
		//Endpoint.publish("http://localhost:8088/DynWebServices", new ProductCatalog());
		Endpoint.publish("http://localhost:8088/DynWebServices", new Product());
	}
}
