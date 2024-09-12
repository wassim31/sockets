import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 12345)) {

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            
            writer.println("hello it's me client");
            System.out.println(reader.readLine());
            socket.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
