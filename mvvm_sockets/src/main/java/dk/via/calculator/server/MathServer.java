package dk.via.calculator.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        UDPBroadcaster broadcaster = new UDPBroadcaster("230.0.0.0", 8888);
        while(true) {
            System.out.println("Server is ready for input port 8080");
            Socket socket = serverSocket.accept();
            MathCommunicator communicator = new MathCommunicator(socket, broadcaster);
            Thread communicatorThread = new Thread(communicator);
            communicatorThread.start();
        }
    }
}
