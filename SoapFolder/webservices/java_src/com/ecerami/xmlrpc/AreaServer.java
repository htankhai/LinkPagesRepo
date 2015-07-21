package com.ecerami.xmlrpc;

import java.io.IOException;
import helma.xmlrpc.WebServer;
import helma.xmlrpc.XmlRpc;

public class AreaServer {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(
                "Usage: java AreaServer [port]");
            System.exit(-1);
        }

        try {
          startServer(args);
        } catch (IOException e) {
            System.out.println("Could not start server: " +
                e.getMessage());
        }
    }

    public static void startServer(String[] args) throws IOException {
            // Start the server, using built-in version
            System.out.println("Attempting to start XML-RPC Server...");
            WebServer server = new WebServer(Integer.parseInt(args[0]));

            System.out.println("Started successfully.");

            // Register our handler class as area
            server.addHandler("area", new AreaHandler());
            System.out.println(
                "Registered AreaHandler class to area.");

            System.out.println("Now accepting requests. (Halt program to stop.)");

    }

}