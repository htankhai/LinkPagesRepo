/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.soap;

/**
 * "Hello, SOAP!" SOAP Service
 * Provides a personalized greeting to any client application
 */
public class HelloService {

  /**
  *  Says Hello to Client
  */
  public String sayHello (String firstName) {
    return new String ("Hello, "+firstName+"!");
  }
}