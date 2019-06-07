import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class HiClass extends UnicastRemoteObject implements Greetings {
    public Hiclass() throws RemoteException {
        super();
    }

    public void getGreetings() throws RemoteException {
        System.out.println("Hi!");
    }

    public static void main(String[] args) throws Exception {
        System.setSecurityManager(new RMISecurityManager());
        hi = new HiClass();
        Naming.bind("//server:2000/HiClass", hi)
    }
}
