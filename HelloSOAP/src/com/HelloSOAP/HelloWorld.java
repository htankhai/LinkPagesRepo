package com.HelloSOAP;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Hello_World")
public class HelloWorld {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello_")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}


//http://htan:8080/HelloSOAP/Hello_World
//http://htan:8080/HelloSOAP/Hello_World?wsdl

//to access the web service.
//try { 	com.javapapers.webserviceclient.HelloWorld_Service service = new com.javapapers.webserviceclient.HelloWorld_Service(); 	com.javapapers.webserviceclient.HelloWorld port = service.getHelloWorldPort(); 	 // TODO initialize WS operation arguments here 	java.lang.String name = ""; 	// TODO process result here 	java.lang.String result = port.hello(name); 	out.println("Result = "+result);     } catch (Exception ex) { 	// TODO handle custom exceptions here     }

//for vaiable ‘name’ assign a string value you prefer like,
//java.lang.String name = "java";
//Right click the project and select ‘run’ and you get “Result = Hello java ”