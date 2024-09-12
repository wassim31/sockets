import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class GreetingImpl extends UnicastRemoteObject implements Greeting {

    public GreetingImpl() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "hello world\n";
    }

}
