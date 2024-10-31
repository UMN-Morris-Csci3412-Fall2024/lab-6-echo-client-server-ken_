package echoserver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class EchoServer {

    // Port number
    private static final int PORT_NUMBER = 6013;

    public static void main(String[] args) {

        try {

            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);

            while (true) {

                // Wait for a client to connect
                Socket client = serverSocket.accept();
                System.out.println("Client connected");

                // Create a reader and writer
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();

                int byteRead;

                // Read from the input stream and write to the output stream
                while ((byteRead = input.read()) != -1) {
                    // Write to the output stream
                    output.write(byteRead);
                    output.flush();
                }

                // Close the client socket
                client.close();
            }
        } catch (IOException ioe) {

            // Print the exception
            System.out.println("We caught an exception");
            System.err.println(ioe);
        }

    }
}