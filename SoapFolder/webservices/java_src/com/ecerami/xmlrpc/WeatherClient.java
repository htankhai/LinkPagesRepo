package com.ecerami.xmlrpc;

import java.io.IOException;
import java.util.Vector;
import helma.xmlrpc.XmlRpc;
import helma.xmlrpc.XmlRpcClient;
import helma.xmlrpc.XmlRpcException;

public class WeatherClient {

    public static void main(String args[]) {
        WeatherClient client = new WeatherClient();
        int temperature;

        try {
            temperature = client.getWeather("10016");
            // Report the results
            System.out.println("Current Temperature: " + temperature);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (XmlRpcException e) {
            System.out.println("Exception within XML-RPC: " + e.getMessage());
        }
    }

    public int getWeather (String zipcode)
      throws IOException, XmlRpcException {

            // Create the client, identifying the server
            XmlRpcClient client =
                new XmlRpcClient("http://localhost:8898");

            // Create the request parameters using user input
            Vector params = new Vector();
            params.addElement(new String (zipcode));

            // Issue a request
            Object result =
               client.execute("weather.getWeather", params);

            String resultStr = result.toString();
            int temperature = Integer.parseInt(resultStr);
            return temperature;
    }

}


