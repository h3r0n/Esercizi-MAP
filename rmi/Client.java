import java.rmi.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Interface i = (Interface) Naming.lookup("//localhost:8080/Interface");
        i.doSomething();
    }
}