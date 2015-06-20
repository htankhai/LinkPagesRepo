
//  The following package line was inserted manually.
//  All other code was generated automatically by the
//  IBM proxygen tool
package com.ecerami.wsdl.ibm;

import java.net.*;
      
import java.util.*;
import org.apache.soap.*;
import org.apache.soap.encoding.*;
import org.apache.soap.rpc.*;
import org.apache.soap.util.xml.*;

public class Hello_PortTypeProxy
{
  private Call call = new Call();
  private URL url = null;
  private String SOAPActionURI = "";
  private SOAPMappingRegistry smr = call.getSOAPMappingRegistry();

  public Hello_PortTypeProxy() throws MalformedURLException
  {
    call.setTargetObjectURI("urn:examples:helloservice");
    call.setEncodingStyleURI("http://schemas.xmlsoap.org/soap/encoding/");
    this.url = new URL("http://localhost:8080/soap/servlet/rpcrouter");
    this.SOAPActionURI = "sayHello";
  }

  public synchronized void setEndPoint(URL url)
  {
    this.url = url;
  }

  public synchronized URL getEndPoint()
  {
    return url;
  }

  public synchronized java.lang.String sayHello
    (java.lang.String firstName) throws SOAPException
  {
    if (url == null)
    {
      throw new SOAPException(Constants.FAULT_CODE_CLIENT,
      "A URL must be specified via " +
      "Hello_PortTypeProxy.setEndPoint(URL).");
    }

    call.setMethodName("sayHello");
    Vector params = new Vector();
    Parameter firstNameParam = new Parameter("firstName",
      java.lang.String.class, firstName, null);
    params.addElement(firstNameParam);
    call.setParams(params);
    Response resp = call.invoke(url, SOAPActionURI);

    // Check the response.
    if (resp.generatedFault())
    {
      Fault fault = resp.getFault();

      throw new SOAPException(fault.getFaultCode(), fault.getFaultString());
    }
    else
    {
      Parameter retValue = resp.getReturnValue();
      return (java.lang.String)retValue.getValue();
    }
  }

}
