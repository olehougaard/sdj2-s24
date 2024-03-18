package dk.via.calculator.client;

import com.google.gson.Gson;

import dk.via.calculator.model.Expression;
import dk.via.calculator.model.Result;
import dk.via.calculator.socket.StreamFactory;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;

public class MathClientImplementation implements MathClient {
    private static final String EXIT_JSON = """
    {"operator": "exit"}
    """;

    private final Socket socket;
    private final PrintWriter output;
    private final BufferedReader input;
    private final Gson gson;
    private final PropertyChangeSupport support;
    private final MessageListener listener;

    public MathClientImplementation(String host, int port) throws IOException {
        socket = new Socket(host, port);
        output = StreamFactory.createWriter(socket);
        input = StreamFactory.createReader(socket);
        gson = new Gson();
        support = new PropertyChangeSupport(this);

        listener = new MessageListener(this, "230.0.0.0", 8888);
        Thread thread = new Thread(listener);
        thread.start();
    }

    private double compute(Expression expression) throws IOException {
        String json = gson.toJson(expression);
        output.println(json);
        output.flush();
        String resultJson = input.readLine();
        Result result = gson.fromJson(resultJson, Result.class);
        return result.getValue();
    }

    @Override
    public double plus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("+", operand1, operand2);
        return compute(expression);
    }

    @Override
    public double minus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("-", operand1, operand2);
        return compute(expression);
    }

    @Override
    public double times(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("*", operand1, operand2);
        return compute(expression);
    }

    @Override
    public double divide(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("/", operand1, operand2);
        return compute(expression);
    }

    @Override
    public void close() throws IOException {
        output.println(EXIT_JSON);
        output.flush();
        socket.close();
        listener.close();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void receiveBroadcast(String message) {
        Result result = gson.fromJson(message, Result.class);
        support.firePropertyChange("result", null, result);
    }
}
