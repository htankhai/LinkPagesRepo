package com.tutorialspoint.ws;
import javax.jws.WebService;
@WebService(endpointInterface="com.tutorialspoint.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld  {
	@Override
	public String getHelloWorldMessage(String myName){
		return("Hello "+myName+" to JAX WS world");
	}

}
