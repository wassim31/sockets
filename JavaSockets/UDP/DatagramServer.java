import java.net.*;

public class DatagramServer {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(5000);
            byte[] receivedData = new byte[1024];

            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);

            server.receive(receivedPacket);
            String clientMessage = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            System.out.println("Received from client: " + clientMessage);

            InetAddress ip = receivedPacket.getAddress();
            int port = receivedPacket.getPort();

            String message = "hello client , well received";
            byte[] sentData = message.getBytes();

            server.send(new DatagramPacket(sentData, sentData.length, ip, port));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
