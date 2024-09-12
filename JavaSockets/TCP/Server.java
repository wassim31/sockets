import java.net.*;
import java.io.*;

public class Server {
    private static int counter = 0;
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server started at port 1234");
            while(true) {
                Socket socket = server.accept();
                System.out.println("Client " + (counter++) + " connected");


            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    Socket socket;
    
    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        InputStream input;
        try {
            input = this.socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        OutputStream output;
        try {
            output = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter writer = new PrintWriter(output,true);

        writer.println("hi client, it's me server");
    }
    
}
