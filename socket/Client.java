import java.net.*;
import java.io.*;

class Server {
    public static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);

        Socket socket = server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
    }
}

class Client {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, Server.PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

        String str = in.readLine();
        out.println(str);
    }
}