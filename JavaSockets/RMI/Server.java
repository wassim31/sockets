import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(2000);
        Greeting greeting = new GreetingImpl();

        registry.rebind("greeting", greeting);

    }
}
