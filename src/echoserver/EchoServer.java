package echoserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    // Port number
    private static final int PORT_NUMBER = 6013;
    public static void main(String[] args) {

        try {

            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);

            // Wait for a connection
            Socket client = serverSocket.accept();

            // Get the input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            int byteRead;

            // Read from the input stream and write to the output stream
            while ((byteRead = input.read()) != -1) {
                // Write to the output stream
                output.write(byteRead);
                output.flush();
            }

            // Close the socket
            client.close();

        } catch (IOException ioe) {
            // Print the exception
            System.out.println("We caught an exception");
            System.err.println(ioe);
        }
        

    }
}