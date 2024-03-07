package dk.via.echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Listening on " + serverSocket.getLocalPort());
        while(true) {
            System.out.println("Ready for next connection");
            Socket socket = serverSocket.accept();
            Runnable communicator = new EchoCommunicator(socket);
            Thread thread = new Thread(communicator);
            thread.start();
        }
    }
}
