import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(2000);

        Greeting stub = (Greeting) registry.lookup("greeting");

        System.out.println(stub.sayHello());

    }
}
