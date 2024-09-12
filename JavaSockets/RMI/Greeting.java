import java.rmi.*;

public interface Greeting extends Remote {
    public String sayHello() throws RemoteException;
}
