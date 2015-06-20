/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.wsdl;

import java.net.*;
import com.ecerami.wsdl.ibm.*;

/**
 * SOAP Invoker.  This class invokes the Hello_PortTypeProxy class.
 * Hello_PortTypeProxy.java is automatically generated via the IBM
 * proxygen command line tool.
*/
public class Invoke_Hello {

  /**
   * SOAP Invoker.
   */
  public String sayHello (String msg) throws Exception {
    Hello_PortTypeProxy proxy = new Hello_PortTypeProxy ();
    String greeting = proxy.sayHello (msg);
    return greeting;
  }

  /**
   * Main Method
   */
  public static void main (String[] args) throws Exception {
    Invoke_Hello hello = new Invoke_Hello();
    System.out.println ("Hello Service Response:  ");
    String greeting = hello.sayHello("World");
    System.out.println (greeting);
  }

}
