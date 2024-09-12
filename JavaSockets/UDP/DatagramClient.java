import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverIp = InetAddress.getByName("localhost");
            int port = 5000;

            String message = "hi server , it's client";
            byte[] sentData = message.getBytes();

            clientSocket.send(new DatagramPacket(sentData, sentData.length, serverIp, port));
            byte[] buffer = new byte[1024];
            DatagramPacket receivedData = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(receivedData);
            System.out.println("the message is: " + new String(receivedData.getData(), 0, receivedData.getLength()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
