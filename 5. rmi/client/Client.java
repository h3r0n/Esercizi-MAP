import java.rmi.*;
import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) {
        
        System.setSecurityManager(new RMISecurityManager());

        Greetings g = (Greetings) Naming.lookup("//server:2000/Hiclass");
        g.getGreetings();
    }
}