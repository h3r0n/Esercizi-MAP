import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(address, Server.PORT);

        //BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

        out.println("Ping");

        //Thread.sleep(1000);

        //String str = in.readLine();
        //out.println(str);

        //in.close();
        out.close();
    }
}