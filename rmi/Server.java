import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;

public class Server extends UnicastRemoteObject implements Interface {
    Server() throws RemoteException {}

    public void doSomething() throws RemoteException {
        System.out.println("Did something.");
    }

    public static void main(String[] args) throws Exception {
        
        //System.setSecurityManager(new RMISecurityManager());
        LocateRegistry.createRegistry(8080);
        Server s = new Server();
        Naming.rebind("//localhost:8080/Interface", s);
    }
}