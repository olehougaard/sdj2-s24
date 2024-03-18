package dk.via.calculator.server;

import com.google.gson.Gson;
import dk.via.calculator.model.Expression;
import dk.via.calculator.model.Result;
import dk.via.calculator.socket.StreamFactory;

import java.io.*;
import java.net.Socket;

public class MathCommunicator implements Runnable {
    private final Socket socket;
    private final UDPBroadcaster broadcaster;
    private final Gson gson;
    private final Model model;

    public MathCommunicator(Socket socket, UDPBroadcaster broadcaster) {
        this.socket = socket;
        this.broadcaster = broadcaster;
        this.gson = new Gson();
        model = new Model();
    }

    private void communicate() throws IOException {
        try {
            BufferedReader input = StreamFactory.createReader(socket);
            PrintWriter output = StreamFactory.createWriter(socket);
            while (true) {
                String json = input.readLine();
                Expression expression = gson.fromJson(json, Expression.class);
                if (expression.getOperator().equals("exit")) {
                    System.out.println("Exiting");
                    break;
                }
                Result r = model.compute(expression);
                String resultJson = gson.toJson(r);
                output.println(resultJson);
                output.flush();
                broadcaster.broadcast(resultJson);
            }
        } finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            communicate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
