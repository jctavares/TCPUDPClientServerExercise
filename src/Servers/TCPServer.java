package Servers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] argv) throws Exception {
        String messageFromClient, capitalizedMessage;
        ServerSocket welcomeSocket;

        welcomeSocket = new ServerSocket(6789);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            messageFromClient = inFromClient.readLine();
            capitalizedMessage = messageFromClient.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedMessage);
        }
    }
}
