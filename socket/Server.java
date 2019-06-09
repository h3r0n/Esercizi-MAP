import java.io.*;
import java.net.*;

public class Server { //jabber = chiacchiera
    // Scegli una port al di fuori del range 1-1024:
    public static final int PORT = 8080;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();
        String str = "start";

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        for (int i=0; i<10; i++) {
            str = in.readLine();
            System.out.println(str);
            out.println(str);
        }

        socket.close();
        serverSocket.close();
    }
} 

