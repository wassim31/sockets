
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.*;
import java.util.Scanner;

public class Client_rem {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName("localhost");
            int port = 5000;
            String message = "hello its client";
            byte[] buffer = message.getBytes();
            DatagramPacket sentPacket = new DatagramPacket(buffer, buffer.length, ip, port);
            socket.send(sentPacket);

            byte[] recieved = new byte[1024];
            DatagramPacket receivedData = new DatagramPacket(recieved, recieved.length);
            socket.receive(receivedData);
            System.out.println(new String(receivedData.getData(), 0, receivedData.getLength()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
