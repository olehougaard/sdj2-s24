package dk.via.exercise11_1;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class LoginClient implements Closeable {
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;
    private final Gson gson;

    public LoginClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.writer = new PrintWriter(socket.getOutputStream());
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        gson = new Gson();
    }

    public boolean login(String username, String password) throws IOException {
        writer.println("connect");
        writer.flush();
        String reply = reader.readLine();
        if (!reply.equals("login required")) {
            throw new IOException("Protocol failure");
        }
        Login login = new Login(username, password);
        String loginJSON = gson.toJson(login);
        writer.println(loginJSON);
        writer.flush();
        reply = reader.readLine();
        return reply.equals("Approved");
    }

    @Override
    public void close() throws IOException {
        writer.println("Disconnect");
        writer.flush();
        String reply = reader.readLine();
        if (!reply.equals("Disconnected")) {
            throw new IOException("Protocol failure");
        }
        socket.close();
    }
}
