package com.ecerami.xmlrpc;

import java.io.IOException;
import java.util.Vector;
import helma.xmlrpc.XmlRpc;
import helma.xmlrpc.XmlRpcClient;
import helma.xmlrpc.XmlRpcException;

public class AreaClient {

    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println(
                "Usage: java AreaClient [radius]");
            System.exit(-1);
        }
        AreaClient client = new AreaClient();
        double radius = Double.parseDouble(args[0]);

        try {
            double area = client.areaCircle(radius);
            // Report the results
            System.out.println("The area of the circle would be: " + area);

        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (XmlRpcException e) {
            System.out.println("Exception within XML-RPC: " + e.getMessage());
        }
    }

    public double areaCircle (double radius)
      throws IOException, XmlRpcException {

            // Create the client, identifying the server
            XmlRpcClient client =
                new XmlRpcClient("http://localhost:8899/");

            // Create the request parameters using user input
            Vector params = new Vector();
            params.addElement(new Double (radius));

            // Issue a request
            Object result =
               client.execute("area.circleArea", params);

            String resultStr = result.toString();
            double area = Double.parseDouble(resultStr);
            return area;
    }

}


