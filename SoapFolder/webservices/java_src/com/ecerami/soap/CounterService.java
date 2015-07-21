/*
 * Copyright (c) 2001 Ethan Cerami.  All rights reserved.
 * This code is from the book XML Web Services Essentials.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
*/
package com.ecerami.soap;

/**
 * A Sample SOAP Service
 * Illustrates Session v. Application Scope
 *
 * When this service is deployed with Scope="Session",
 * server will instantiate one instance of CounterService
 * per client.  CounterService will then maintain total
 * number of requests per session.
 *
 * When this service is deployed with Scope="Application",
 * server will instantiate just one instance of CounterService.
 * CounterService will then maintain total number of requests
 * across all sessions.
 *
 */
public class CounterService {
  private int counter;    //  Number of requests

  /**
   * Constructor
   */
  public CounterService () { counter = 0; }

  /**
  *  Return number of requests
  */
  public int getCounter () { return ++counter; }
}