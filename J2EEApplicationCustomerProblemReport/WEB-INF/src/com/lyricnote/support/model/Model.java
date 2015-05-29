/**
*  Copyright (c) 2002 by Phil Hanna
*  All rights reserved.
*  
*  You may study, use, modify, and distribute this
*  software for any purpose provided that this
*  copyright notice appears in all copies.
*  
*  This software is provided without warranty
*  either expressed or implied.
*/
package com.lyricnote.support.model;

import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

/**
* The model component in the Model-View-Controller architecture
* of the product support application. The model is designed
* to be used in a dedicated HTTP session with a single user,
* however, there is no HTTP-specific code.  This allows the
* model to be tested by a batch driver.
*/
public abstract class Model implements Serializable
{
   // Class variables and constants

   public static final SimpleDateFormat DATE_FORMAT =
      new SimpleDateFormat("yyyy-MM-dd");

   public static final SimpleDateFormat DATE_TIME_FORMAT =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   // Instance variables

   private transient Connection con;
   private List customers;
   private String customerID;
   private List products;
   private String productID;
   private List problems;
   private String problemID;
   private List problemLogs;
   private Map eventMap;

   // ===========================================
   //    Configuration and database methods
   // ===========================================

   /**
   * Returns the current connection
   */
   public Connection getConnection()
   {
      return con;
   }

   /**
   * Sets the connection (only visible to subclasses)
   * @param con the connection
   */
   protected void setConnection(Connection con)
   {
      this.con = con;
   }

   /**
   * Opens a database connection.
   * @exception SQLException if the connection fails
   * or if it already exists
   */
   public abstract void connect() throws SQLException;

   /**
   * Closes the current connection
   */
   public void disconnect() throws SQLException
   {
      if (con != null)
         con.close();
   }

   /**
   * Returns true if there is an active connection
   */
   public boolean isConnected()
   {
      return (con != null);
   }

   // ===========================================
   //    Customer methods
   // ===========================================

   /**
   * Returns the customer object corresponding to
   * the current customer ID
   * @exception SQLException if a database error occurs
   */
   public Customer getCustomer()
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      // Verify that there is a current customer ID

      if (customerID == null)
         throw new SQLException("No customer ID");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      Customer customer = null;

      try {

         // Prepare the SQL statement

         final String SQL =
              "SELECT   * "
            + "FROM     customers "
            + "WHERE    customerID=?";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, customerID);

         // Execute the query

         rs = pstmt.executeQuery();
         if (rs.next())
            customer = Customer.load(rs);
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }

      // Return the customer

      return customer;
   }

   /**
   * Returns the current customer search results
   */
   public List getCustomers()
   {
      return customers;
   }

   /**
   * Uses the specified customer search argument to query
   * the database for matching customers.  Creates a list
   * of customer objects.
   * @param searchArgument the search argument
   * @exception SQLException if a database error occurs
   */
   public void customerSearch(String searchArgument)
      throws SQLException
   {
      // Verify that a connection exists and that
      // the search argument has been specified

      if (!isConnected())
         throw new SQLException("No connection");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      customers = null;

      try {

         // Prepare the SQL statement

         final String SQL =
              "SELECT   * "
            + "FROM     customers "
            + "WHERE    name like ? "
            + "ORDER BY name";

         pstmt = con.prepareStatement(SQL);
         searchArgument = searchArgument.trim();
         searchArgument = "%" + searchArgument + "%";
         pstmt.setString(1, searchArgument);

         // Execute the query and copy the results
         // to a List

         rs = pstmt.executeQuery();
         customers = new LinkedList();
         while (rs.next()) {
            customers.add(Customer.load(rs));
         }
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }
   }

   /**
   * Returns the customerID.
   */
   public String getCustomerID()
   {
      return customerID;
   }

   /**
   * Sets the customerID.
   * @param customerID the customerID.
   */
   public void setCustomerID(String customerID)
   {
      this.customerID = customerID;
   }

   // ===========================================
   //    Product methods
   // ===========================================

   /**
   * Returns the product object corresponding to
   * the current product ID
   * @exception SQLException if a database error occurs
   */
   public Product getProduct()
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      // Verify that a current product ID exists

      if (productID == null)
         throw new SQLException("No product ID");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      Product product = null;

      try {

         // Prepare the SQL statement

         final String SQL =
              "SELECT   * "
            + "FROM     products "
            + "WHERE    productID=?";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, productID);

         // Execute the query

         rs = pstmt.executeQuery();
         if (rs.next())
            product = Product.load(rs);
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }

      // Return the product

      return product;
   }

   /**
   * Returns the current product search results
   */
   public List getProducts()
   {
      return products;
   }

   /**
   * Uses the specified product search argument to query
   * the database for matching products.  Creates a list
   * of product objects.
   * @param searchArgument the search argument
   * @exception SQLException if a database error occurs
   */
   public void productSearch(String searchArgument)
      throws SQLException
   {
      // Verify that a connection exists and that
      // the search argument has been specified

      if (!isConnected())
         throw new SQLException("No connection");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      products = null;

      try {

         // Prepare the SQL statement

         final String SQL = 
              "SELECT   * "
            + "FROM     products "
            + "WHERE    name like ? "
            + "ORDER BY name";

         pstmt = con.prepareStatement(SQL);
         searchArgument = searchArgument.trim();
         searchArgument = "%" + searchArgument + "%";
         pstmt.setString(1, searchArgument);

         // Execute the query and copy the results
         // to a List

         rs = pstmt.executeQuery();
         products = new LinkedList();
         while (rs.next())
            products.add(Product.load(rs));
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }
   }

   /**
   * Returns the productID.
   */
   public String getProductID()
   {
      return productID;
   }

   /**
   * Sets the productID.
   * @param productID the productID.
   */
   public void setProductID(String productID)
   {
      this.productID = productID;
   }

   // ===========================================
   //    Customer/product methods
   // ===========================================

   /**
   * Returns a list of <code>CustomerProduct</code> objects
   * for the current customer.
   * @exception SQLException if a database error occurs
   */
   public List getCustomerProducts()
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      // Verify that a current customer ID exists

      if (customerID == null)
         throw new SQLException("No customer ID");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List list = null;

      try {

         // Prepare the SQL statement

         final String SQL = 
              "SELECT   * "
            + "FROM     custprod "
            + "WHERE    customerID = ? "
            + "ORDER BY datePurchased DESC";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, customerID);

         // Execute the query and populate the list

         rs = pstmt.executeQuery();
         list = new LinkedList();
         while (rs.next())
            list.add(CustomerProduct.load(rs));
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }

      // Return the list

      return list;
   }

   // ===========================================
   //    Problem methods
   // ===========================================

   /**
   * Factory method to create a new problem record
   * and add it to the database. Expects the customer
   * ID and product ID to be set already.
   */
   public void newProblem() throws SQLException
   {
      if (getCustomerID() == null)
         throw new SQLException
         ("No customer ID");

      if (getProductID() == null)
         throw new SQLException
         ("No product ID");

      Problem problem = new Problem();

      problemID = Problem.assignProblemID(con);
      problem.setProblemID(problemID);
      problem.setDescription("");
      problem.setSeverity(2);
      problem.setDateReported(new Date());
      problem.setCustomerID(getCustomerID());
      problem.setProductID(getProductID());

      // Add to database

      PreparedStatement pstmt = null;
      try {
         final String SQL =
              "INSERT "
            + "INTO     problems "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, problemID);
         pstmt.setString(2, problem.getDescription());
         pstmt.setInt(3, problem.getSeverity());
         pstmt.setTimestamp
            (4, Model.toTimestamp(problem.getDateReported()));
         pstmt.setNull(5, Types.TIMESTAMP);
         pstmt.setString(6, problem.getCustomerID());
         pstmt.setString(7, problem.getProductID());
         pstmt.executeUpdate();
      }
      finally {
         if (pstmt != null)
            pstmt.close();
      }
   }

   /**
   * Updates the problem record in the database
   * @param problem the problem object
   * @exception SQLException if a database error occurs
   */
   public void updateProblem(Problem problem)
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      PreparedStatement pstmt = null;
      try {

         boolean resolved = problem.getDateResolved() != null;
         String SQL =
              "UPDATE   problems "
            + "SET      description=?,"
            + "         severity=?";

         if (resolved)
            SQL += ",dateResolved=?";

         SQL += " WHERE problemID=?";

         // Prepare the SQL statement

         pstmt = con.prepareStatement(SQL);

         // Set the parameters - note that the columns may vary

         int col = 0;
         pstmt.setString(++col, problem.getDescription());
         pstmt.setInt(++col, problem.getSeverity());
         if (resolved) {
            Date dateResolved = problem.getDateResolved();
            Timestamp ts = Model.toTimestamp(dateResolved);
            pstmt.setTimestamp(++col, ts);
         }
         pstmt.setString(++col, problem.getProblemID());

         // Execute the update

         pstmt.executeUpdate();
      }
      finally {
         if (pstmt != null)
            pstmt.close();
      }
   }

   /**
   * Returns the problem object corresponding to
   * the current problem ID
   * @exception SQLException if a database error occurs
   */
   public Problem getProblem()
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      // Verify that a current problem ID exists

      if (problemID == null)
         throw new SQLException("No problem ID");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      Problem problem = null;

      try {

         // Prepare the SQL statement

         final String SQL =
              "SELECT   * "
            + "FROM     problems "
            + "WHERE    problemID=?";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, problemID);

         // Execute the query

         rs = pstmt.executeQuery();
         if (rs.next())
            problem = Problem.load(rs);
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }

      // Return the problem

      return problem;
   }

   /**
   * Returns the current problem search results
   */
   public List getProblems()
   {
      return problems;
   }

   /**
   * Uses the specified customer ID to query
   * the database for problems for that customer.
   * Creates a list of problem objects.
   * @exception SQLException if a database error occurs
   */
   public void customerProblemsSearch(String customerID)
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      problems = null;

      try {

         // Prepare the SQL statement

         final String SQL =
              "SELECT   * "
            + "FROM     problems "
            + "WHERE    customerID=?";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, customerID);

         // Execute the query and copy the results
         // to a List

         rs = pstmt.executeQuery();
         problems = new LinkedList();
         while (rs.next())
            problems.add(Problem.load(rs));
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }
   }

   /**
   * Uses the specified product ID to query
   * the database for problems for that product.
   * Creates a list of problem objects.
   * @exception SQLException if a database error occurs
   */
   public void productProblemsSearch(String productID)
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      problems = null;

      try {

         // Prepare the SQL statement

         final String SQL =
              "SELECT   * " 
            + "FROM     problems "
            + "WHERE    productID = ?";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, productID);

         // Execute the query and copy the results
         // to a List

         rs = pstmt.executeQuery();
         problems = new LinkedList();
         while (rs.next())
            problems.add(Problem.load(rs));
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }
   }

   /**
   * Returns the problemID.
   */
   public String getProblemID()
   {
      return problemID;
   }

   /**
   * Sets the problemID.
   * @param problemID the problemID.
   */
   public void setProblemID(String problemID)
   {
      this.problemID = problemID;
   }

   // ===========================================
   //    ProblemLog methods
   // ===========================================

   /**
   * Adds a new problem log entry
   * @param log a problem log object
   * @exception SQLException if a database error occurs
   */
   public void addProblemLogEntry(ProblemLog log)
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      PreparedStatement pstmt = null;

      try {

         // Prepare the insert SQL

         final String SQL =
              "INSERT "
            + "INTO     problog "
            + "VALUES(?, ?, ?, ?)";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, log.getProblemID());
         pstmt.setTimestamp(2,
            Model.toTimestamp(log.getLogTime()));
         pstmt.setString(3, log.getEventID());
         pstmt.setString(4, log.getComments());

         // Execute the statement

         pstmt.executeUpdate();
      }
      finally {
         if (pstmt != null)
            pstmt.close();
      }
   }

   /**
   * Uses the specified problem ID to query
   * the database for problem log entries for
   * that problem.
   * Creates a list of problem log objects.
   * @exception SQLException if a database error occurs
   */
   public void problemLogSearch(String problemID)
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      problemLogs = null;

      try {

         // Prepare the SQL statement

         final String SQL =
              "SELECT   * "
            + "FROM     problog "
            + "WHERE    problemID = ?";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, problemID);

         // Execute the query and copy the results
         // to a List

         rs = pstmt.executeQuery();
         problemLogs = new LinkedList();
         while (rs.next())
            problemLogs.add(ProblemLog.load(rs));
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }
   }

   /**
   * Returns the problemLogs.
   */
   public List getProblemLogs()
   {
      return problemLogs;
   }

   // ===========================================
   //    Employee methods
   // ===========================================

   /**
   * Returns the employee object corresponding to
   * the specified employee ID
   * @param employeeID the employee ID
   * @exception SQLException if a database error occurs
   */
   public Employee getEmployee(String employeeID)
      throws SQLException
   {
      // Verify that a connection exists

      if (!isConnected())
         throw new SQLException("No connection");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      Employee employee = null;

      try {

         // Prepare the query SQL

         final String SQL =
              "SELECT   * "
            + "FROM     employees "
            + "WHERE    employeeId = ?";

         pstmt = con.prepareStatement(SQL);
         pstmt.setString(1, employeeID);

         // Execute the query

         rs = pstmt.executeQuery();
         if (rs.next())
            employee = Employee.load(rs);
      }
      finally {
         if (rs != null)
            rs.close();
         if (pstmt != null)
            pstmt.close();
      }

      // Return the employee

      return employee;
   }

   // ===========================================
   //    Event methods
   // ===========================================

   /**
   * Returns <code>true</code> if the specified event is valid.
   * @param eventID event ID code
   */
   public boolean isValidEvent(String eventID)
   {
      if (eventMap == null)
         loadEventMap();
      return eventMap.get(eventID) != null;
   }

   /**
   * Returns <code>true</code> if the specified event
   * is a closing event
   * @param eventID event ID code
   */
   public boolean isClosingEvent(String eventID)
   {
      if (eventMap == null)
         loadEventMap();
      Event event = (Event) eventMap.get(eventID);
      if (event == null)
         return false;
      return event.isClosingEvent();
   }

   private void loadEventMap()
   {
      eventMap = new HashMap();
      Statement stmt = null;
      ResultSet rs = null;
      try {
         final String SQL = "select * from events";
         stmt = con.createStatement();
         rs = stmt.executeQuery(SQL);
         while (rs.next()) {
            Event event = Event.load(rs);
            eventMap.put(event.getEventID(), event);
         }
      }
      catch (SQLException e) {
         e.printStackTrace();
      }
      finally {
         try {
            if (rs != null)
               rs.close();
            if (stmt != null)
               stmt.close();
         }
         catch (SQLException ignore) {
         }
      }
   }

   // ===========================================
   //    Class methods
   // ===========================================

   /**
   * Formats a date using the default JDBC format
   */
   public static String formatDate(Date d)
   {
      return d == null ? "" : DATE_FORMAT.format(d);
   }

   /**
   * Formats a timestamp using the default JDBC format
   */
   public static String formatDateTime(Date d)
   {
      return d == null ? "" : DATE_TIME_FORMAT.format(d);
   }

   /**
   * Converts a java.util.Date to a java.sql.Timestamp
   */
   public static Timestamp toTimestamp(Date d)
   {
      return (d == null)
         ? null
         : new Timestamp(d.getTime());
   }

   /**
   * Encloses a string in quotation marks
   * if it contains a comma.
   * @param s the string
   */
   public static String quote(String s)
   {
      if (s != null) {
         if (s.indexOf(",") > -1) {
            StringBuffer sb = new StringBuffer();
            sb.append('"');
            sb.append(s);
            sb.append('"');
            s = sb.toString();
         }
      }
      return s;
   }
}
