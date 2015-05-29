package jax_ws;
import javax.xml.ws.Endpoint;  
//Endpoint publisher 
public class HelloWorldPublisher {
	public static void main(String[] args) {  
		Endpoint.publish("http://localhost:7780/ws/hello", new HelloWorldImpl());  
	}  
}

//see the generated WSDL file by visiting the URL:

//http://localhost:7779/ws/hello?wsdl  