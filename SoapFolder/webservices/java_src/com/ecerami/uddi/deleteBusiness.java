/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.uddi;

/**
 * UDDI Program:  deletes the BusinessEntity
 * Specify username, password and businesskey on command line.
 * Example usage:
 * java saveBusiness ethan@ecerami.com
 *   password ff0e960a-6375-4b3f-8fa3-5921a080b1c2
 */
import com.ibm.uddi.*;
import com.ibm.uddi.client.*;
import com.ibm.uddi.datatype.business.*;
import com.ibm.uddi.response.*;
import java.util.Vector;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;

public class deleteBusiness {
  private AuthToken token;
  private UDDIProxy proxy;

  /**
   * Main Method
   */
  public static void main (String args[]) {
    deleteBusiness publish = null;
    try {
      System.out.println("Deleting Business");
      AuthToken token = UDDIUtil.get_authentication_token(args[0], args[1]);
      System.out.println("Authentication Token:  "+token.getAuthInfoString());
      publish = new deleteBusiness(token);
      DispositionReport dr = publish.delete_business (args[2]);
      UDDIUtil.printDispositionReport (dr);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (SOAPException e) {
      e.printStackTrace();
    } catch (UDDIException e) {
      DispositionReport dr = e.getDispositionReport();
      UDDIUtil.printDispositionReport (dr);
      e.printStackTrace();
    }
  }

  /**
   * Constructor
   * @param token UDDI Authentication Token
  */
  public deleteBusiness (AuthToken token) {
    this.token = token;
  }

  /**
   * Delete Business Entity
   * @param businessKey Business Key
   */
  public DispositionReport delete_business (String businessKey)
    throws MalformedURLException, SOAPException, UDDIException {
    //  Point to Microsoft Test Publish URL (SSL)
    proxy = new UDDIProxy();
    proxy.setPublishURL("https://test.uddi.microsoft.com/publish");

    DispositionReport dr =
      proxy.delete_business(token.getAuthInfoString(), businessKey);
    return dr;
  }
}