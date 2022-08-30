package Servers;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket;
        DatagramPacket recievePacket, sendPacket;
        byte[] recieveData, sendData;
        String message, modifiedMessage;
        InetAddress IPAddress;
        int port;

        serverSocket = new DatagramSocket(9876);
        recieveData = new byte[1024];
        sendData = new byte[1024];
        while (true) {
            recievePacket = new DatagramPacket(recieveData, recieveData.length);
            serverSocket.receive(recievePacket);
            message = new String(recievePacket.getData());
            IPAddress = recievePacket.getAddress();
            port = recievePacket.getPort();
            modifiedMessage = message.toUpperCase();
            sendData = modifiedMessage.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }

    }
}
