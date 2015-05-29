import javax.xml.ws.WebServiceRef;


public class JAXWSClient {
public static void main(String[] args) throws Exception {
   
	@WebServiceRef(wsdlLocation = "http://localhost:8080/jaxws-webservice/CalculatorService?WSDL")
	 static CalculatorService service;
    Calculator port = service.getCalculatorPort();
    int ret = port.add(1, 10);
    System.out.println(ret);
  }

}
