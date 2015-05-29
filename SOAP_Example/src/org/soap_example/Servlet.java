package org.soap_example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Servlet extends HttpServlet {
    
    static final long serialVersionUID = 1;
    
    public void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
      
      //GET REQUEST BODY.       
      ServletInputStream i = request.getInputStream();
      int c = 0;
      String xmlrpc = "";
      while((c = i.read()) != -1 ){ xmlrpc += (char)c; }
      
      //EXTRACT PARAMETER.
      int startTag = xmlrpc.indexOf("type='xsi:positiveInteger'>");
      int endTag   = xmlrpc.indexOf("</multiply>");
      String parameter =    xmlrpc.substring(startTag,endTag).replaceAll("type='xsi:positiveInteger'>","");
             parameter = parameter.trim();
      
      //CALCUALTE.
      int multy = new Integer(parameter).intValue();
          multy = 2*multy;
 
      //PREPARE OUTPUT.
      String  xml = "";      
              xml += "<?xml version=\"1.0\"?> \n";
              xml += "<SOAP-ENV:Envelope>     \n";
              xml += "  <SOAP-ENV:Body>       \n";
              xml += "    <result>            \n";
              xml += "      "+multy+         "\n";
              xml += "    </result>           \n";
              xml += "  </SOAP-ENV:Body>      \n";
              xml += "</SOAP-ENV:Envelope>    \n";
      
      //RETURN RESPONSE.    
      response.getWriter().println(xml);
    }
}