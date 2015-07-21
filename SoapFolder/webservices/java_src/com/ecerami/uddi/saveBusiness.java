/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.uddi;

/**
 * UDDI Program:  publishes a new UDDI BusinessEntity
 * record.  Specify username and password on command line.
 * Example usage:
 * java saveBusiness ethan@ecerami.com password
 */
import com.ibm.uddi.*;
import com.ibm.uddi.client.*;
import com.ibm.uddi.datatype.business.*;
import com.ibm.uddi.response.*;
import java.util.Vector;
import java.net.MalformedURLException;
import org.apache.soap.SOAPException;

public class saveBusiness {
  private AuthToken token;
  private UDDIProxy proxy;

  /**
   * Main Method
  */
  public static void main (String args[]) {
    saveBusiness publish = null;
    try {
        System.out.println("Saving New Business:  Acme Parts");
        AuthToken token = UDDIUtil.get_authentication_token(args[0], args[1]);
        System.out.println("Authentication Token:  "+token.getAuthInfoString());
        publish = new saveBusiness(token);
        String businessKey = publish.save_business();
        System.out.println("Published Business Key:  "+businessKey);
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
  public saveBusiness (AuthToken token) {
    this.token = token;
  }

  /**
   * Save New Busines Entity
  */
  public String save_business ()
    throws MalformedURLException, SOAPException, UDDIException {
    String businessKey = null;

    //  Point to Microsoft Test Publish URL (SSL)
    proxy = new UDDIProxy();
    proxy.setPublishURL("https://test.uddi.microsoft.com/publish");

    //  Create Sample Business Entity Record
    BusinessEntity businessEntity = create_business ();
    Vector businessEntityVector = new Vector();
    businessEntityVector.addElement(businessEntity);

    //  Publish new Business Record
    BusinessDetail businessDetail =
      proxy.save_business(token.getAuthInfoString(), businessEntityVector);

    //  Verify publication by extracting new business key
    Vector businessEntities = businessDetail.getBusinessEntityVector();
    if (businessEntities.size() > 0) {
      BusinessEntity returnedBusinessEntity =
        (BusinessEntity)(businessEntities.elementAt(0));
      businessKey = returnedBusinessEntity.getBusinessKey();
    }
    return businessKey;
  }

  /**
   * Create new sample Business Entity record
  */
  private BusinessEntity create_business() {
    Vector businessEntities = new Vector();
    BusinessEntity businessEntity = new BusinessEntity("", "Acme Parts");

    //  Set Business Description
    businessEntity.setDefaultDescriptionString
      ("Maker of fine semiconductor parts");

    //  Set Contact Name and Email
    Contact contact = new Contact ("Ethan Cerami");
    Email email = new Email("cerami@cs.nyu.edu");
    Vector emailVector = new Vector();
    emailVector.addElement(email);
    contact.setEmailVector(emailVector);
    Contacts contacts = new Contacts();
    Vector contactVector = new Vector();
    contactVector.addElement(contact);
    contacts.setContactVector(contactVector);
    businessEntity.setContacts(contacts);
    return businessEntity;
  }
}

