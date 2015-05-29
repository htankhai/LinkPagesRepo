package org.soap_example;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
public class Test_ 
{
	public static void main(String[] args) 
	{
		//DEFINE PARAMETERS.
		String input  = "10";  
		String server = "http://localhost:8080/MyWebApp/MyServlet";

		System.out.println("Parameter="+input+"\n");

		try {

			//DEFINE CONNECTION.
			HttpURLConnection   
			connection = (HttpURLConnection) ( new URL(server).openConnection() );
			connection.setDoOutput       (true);
			connection.setDoInput        (true);
			connection.setRequestMethod  ("POST");
			connection.setRequestProperty("SOAPAction", server);

			//CREATE REQUEST.
			String  xml = "";            
			xml += "<?xml version='1.0'?>                     \n"; 
			xml += "<SOAP-ENV:Envelope>                       \n";            
			xml += "  <SOAP-ENV:Body>                         \n";
			xml += "    <multiply type='xsi:positiveInteger'> \n"; 
			xml += "      "+input+                           "\n"; 
			xml += "    </multiply>                           \n";
			xml += "  </SOAP-ENV:Body>                        \n";
			xml += "</SOAP-ENV:Envelope>                      \n";

			//SEND REQUEST.
			System.out.println(xml);
			OutputStream        out  = connection.getOutputStream();
			OutputStreamWriter  wout = new OutputStreamWriter(out, "UTF-8");
			wout.write(xml);
			wout.flush();
			out .close();

			//READ RESPONSE.
			InputStream in = connection.getInputStream();
			int c;
			String response = "";
			while ((c = in.read()) != -1) { response += (char) c; }
			System.out.println(response);

			//EXTRACT RESULT.
			int    startTag  = response.indexOf("<result>");
			int    endTag    = response.indexOf("</result>");
			String parameter = response.substring(startTag,endTag).replaceAll("<result>","");     
			parameter = parameter.trim();

			//DISPLAY RESULT.
			System.out.println("Result="+parameter);

			//CLOSE ALL.
			in        .close();
			out       .close();
			connection.disconnect();
		}
		catch (IOException e) { System.out.println(e.toString()); } 
	}
}
