package Clients;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] argv) throws Exception {
        String message, modifiedMessage;
        BufferedReader inFromUser, inFromServer;
        Socket clientSocket;
        DataOutputStream outToServer;

        inFromUser = new BufferedReader(new InputStreamReader(System.in));
        clientSocket = new Socket("localhost", 6789);
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        message = inFromUser.readLine();
        outToServer.writeBytes(message + '\n');
        modifiedMessage = inFromServer.readLine();
        System.out.println("MENSAGEM VINDA DO SERVIDOR: " + modifiedMessage);
        clientSocket.close();

    }
}
