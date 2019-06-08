import java.rmi.*;
import java.rmi.server.*;

interface Interface extends Remote {
    public void doSomething() throws RemoteException;
}

class Server extends UnicastRemoteObject implements Interface {
    Server() throws RemoteException {}

    public void doSomething() throws RemoteException {}

    public static void main(String[] args) throws Exception {
        
        System.setSecurityManager(new RMISecurityManager());
        Server s = new Server();
        Naming.bind("//localhost:1099/Interface", s);
    }
}

class Client {
    public static void main(String[] args) throws Exception {
        System.setSecurityManager(new RMISecurityManager());
        Interface s = (Interface) Naming.lookup("//localhost:1099/Interface");
    }
}