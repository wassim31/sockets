
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.*;
import java.util.Scanner;

public class Server_rem {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(5000);
            byte[] buffer = new byte[1024];
            DatagramPacket recievedPacket = new DatagramPacket(buffer, buffer.length);
            server.receive(recievedPacket);
            System.out.println(new String(recievedPacket.getData(), 0, recievedPacket.getLength()));

            InetAddress ip = recievedPacket.getAddress();
            int port = recievedPacket.getPort();

            String sent = "hi its server";
            byte[] sentBuffer = sent.getBytes();

            server.send(new DatagramPacket(sentBuffer, sentBuffer.length, ip, port));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
