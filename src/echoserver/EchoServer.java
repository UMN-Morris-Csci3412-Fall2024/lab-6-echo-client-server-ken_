package echoserver;

import java.io.InputStreamReader;
import java.net.Socket;

public class EchoServer {
        
        public static void main(String[] args) {
            
            ServerSocket serverSocket = null;
            Socket socket = null;
            InputStreamReader inputStreamReader = null;
            OutputStream outputStream = null;
            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;
            
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

                        System.out.println("Client: " + msgFromClient);

                        bufferedWriter.write("MSG Received.");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();

                        if (msgReceived.equals("exit")) {
                            break;
                        }

                socket.close();
                inputStreamReader.close();
                outputStream.close();
                bufferedReader.close();
                bufferedWriter.close();
                }

            }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}