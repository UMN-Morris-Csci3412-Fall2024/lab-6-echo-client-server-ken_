package echoserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            serverSocket = new ServerSocket(8080);

            while (true) {
                try {
                    socket = serverSocket.accept();

                    inputStreamReader = new InputStreamReader(socket.getInputStream());
                    outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                    bufferedReader = new BufferedReader(inputStreamReader);
                    bufferedWriter = new BufferedWriter(outputStreamWriter);

                    while (true) {
                        String msgReceived = bufferedReader.readLine();
                        if (msgReceived == null) break;

                        System.out.println("Client: " + msgReceived);

                        bufferedWriter.write(msgReceived);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();

                        if (msgReceived.equals("exit")) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (socket != null) socket.close();
                        if (inputStreamReader != null) inputStreamReader.close();
                        if (outputStreamWriter != null) outputStreamWriter.close();
                        if (bufferedReader != null) bufferedReader.close();
                        if (bufferedWriter != null) bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}