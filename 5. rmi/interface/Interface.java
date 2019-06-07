import java.rmi.*;
    
interface Greetings extends Remote {
	public void getGreetings() throws RemoteException;
} 
