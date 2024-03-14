package dk.via.exercise11_1;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class LoginCommunicator implements Runnable {
    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;
    private final Gson gson;

    public LoginCommunicator(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
        gson = new Gson();
    }

    @Override
    public void run() {
        try {
            while(true) {
                String method = reader.readLine();
                if (!method.equals("connect")) {
                    break;
                }
                writer.println("login required");
                writer.flush();
                String loginJSON = reader.readLine();
                Login login = gson.fromJson(loginJSON, Login.class);
                if (login.getUsername().isEmpty() || login.getPassword().isEmpty()) { // Need better check in real scenario
                    break;
                }
                writer.println("Approved");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.println("Disconnected");
            writer.flush();
            try {
                socket.close();
                System.out.println("Socket closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
