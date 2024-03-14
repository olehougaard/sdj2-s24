package dk.via.broadcast.server;

import com.google.gson.Gson;
import dk.via.broadcast.model.Expression;
import dk.via.broadcast.model.Result;

import java.io.*;
import java.net.Socket;

public class MathCommunicator implements Runnable {
    private final Socket socket;
    private final UDPBroadcaster broadcaster;
    private final Gson gson;
    private final ServerModel model;

    public MathCommunicator(Socket socket, UDPBroadcaster broadcaster) {
        this.socket = socket;
        this.broadcaster = broadcaster;
        this.gson = new Gson();
        this.model = new ServerModel();
    }

    private void communicate() throws IOException {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter output = new PrintWriter(outputStream);

            while (true) {
                String jsonRequest = input.readLine();
                Expression expression = gson.fromJson(jsonRequest, Expression.class);
                System.out.println(expression.getOperator());
                if ("exit".equals(expression.getOperator())) {
                    System.out.println("Exiting");
                    break;
                } else {
                    Result r = model.compute(expression);
                    String json = gson.toJson(r);
                    output.println(json);
                    output.flush();
                    broadcaster.broadcast(json);
                }
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
