package echoserver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    // Port number
    private static final int PORT_NUMBER = 6013;

    public static void main(String[] args) {

        // Server address
        String server;
        

        if (args.length == 0) {
            server = "127.0.0.1"; // Default server
        } else {
            server = args[0]; // User-specified server
        }

        try {

            // Create a socket
            Socket socket = new Socket(server, PORT_NUMBER);

            
            InputStream input = System.in;

            // Get the input and output streams
            InputStream socketInput = socket.getInputStream();
            OutputStream socketOutput = socket.getOutputStream();

            int byteRead;

            // Read from the input stream and write to the output stream
            while ((byteRead = input.read()) != -1) {
                
                // Write to the server
                socketOutput.write(byteRead);
                socketOutput.flush();

                // Read the response from the server
                int byteReceived = socketInput.read();
                System.out.write(byteReceived);
                System.out.flush();
            }

            // Close the socket
            socket.close();

        } catch (IOException ioe) {
            // Print the exception
            System.out.println("We caught an exception");
            System.err.println(ioe);
        }
    }
}