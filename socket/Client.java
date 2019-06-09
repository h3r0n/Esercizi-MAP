import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", Server.PORT);
        String str = "ping";
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        for (int i=0; i<10; i++) {
            out.println(str);
            str = in.readLine();
            System.out.println(str);
        }

        socket.close();
    }
}
