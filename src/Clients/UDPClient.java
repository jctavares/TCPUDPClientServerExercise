package Clients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) throws Exception {
        String message, modifiedMessage;
        byte[] sendData = new byte[1024];
        byte[] recieveDAta = new byte[1024];
        DatagramPacket sendPacket, recievePacket;
        InetAddress IPAddress;
        BufferedReader inFromUser;
        DatagramSocket clientSocket;

        inFromUser = new BufferedReader(new InputStreamReader(System.in));
        clientSocket = new DatagramSocket();
        IPAddress = InetAddress.getByName("localhost");
        message = inFromUser.readLine();
        sendData = message.getBytes();
        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
        recievePacket = new DatagramPacket(recieveDAta, recieveDAta.length);
        clientSocket.receive(recievePacket);
        modifiedMessage = new String(recievePacket.getData());
        System.out.println("DIRETO DO SERVIDOR: " + modifiedMessage);
        clientSocket.close();
    }
}
