/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.uddi;

import com.ibm.uddi.*;
import com.ibm.uddi.response.*;
import com.ibm.uddi.response.AuthToken;
import com.ibm.uddi.client.*;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;
import java.security.*;

/**
 * UDDI Utility Class
 * Provides static methods for
 * 1)  Authenticating Users
 * 2)  Printing UDDI Disposition Reports
 */
public class UDDIUtil {

  /**
   * Authenticate User and Retrieve Authentication Token
   * @param login UDDI Login Name
   * @param password UDDI password
   * @return UDDI Authentication Token
  */
  static public AuthToken get_authentication_token (String login,
    String password) throws MalformedURLException,
    SOAPException, UDDIException {
    AuthToken token;
    UDDIProxy proxy;

    //  Add SSL Provider
    System.setProperty("java.protocol.handler.pkgs",
      "com.sun.net.ssl.internal.www.protocol");
    Security.addProvider (new com.sun.net.ssl.internal.ssl.Provider());

    //  Point to Microsoft Test Publish URL (SSL)
    proxy = new UDDIProxy();
    proxy.setPublishURL("https://test.uddi.microsoft.com/publish");

    //  Obtain authentication token
    token = proxy.get_authToken(login, password);
    return token;
  }

  /**
   * Print Disposition Report
   * @param dr UDDI Disposition Report
   */
  static public void printDispositionReport (DispositionReport dr) {
    if (dr!=null) {
      System.out.println("UDDI Disposition Report:" +
        "\n errno:"    + dr.getErrno() +
        "\n errCode:"  + dr.getErrCode() +
        "\n errInfoText:" + dr.getErrInfoText());
    }
  }

}

