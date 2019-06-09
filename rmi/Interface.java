import java.rmi.*;

public interface Interface extends Remote {
    public void doSomething() throws RemoteException;
}