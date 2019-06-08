import java.rmi.*;
import java.net.*;
import java.rmi.server.*;
import java.rmi.registry.*;

interface IServer extends Remote {
    public int contaCaratteri(String s) throws RemoteException;
    public String maiuscolo(String s) throws RemoteException;
}

public class Server extends UnicastRemoteObject implements IServer  {
    
    Server() throws RemoteException {}

    public int contaCaratteri(String s) throws RemoteException {
        return s.length();
    }

    public String maiuscolo(String s) throws RemoteException {
        return s.toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        System.setSecurityManager(new RMISecurityManager());

        Server s = new Server();

        Naming.bind("//localhost:1099/server", s);
    }
}

