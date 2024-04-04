package dk.via.uppercase.client;

import dk.via.uppercase.server.UppercaseService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        UppercaseService client = (UppercaseService) registry.lookup("uppercase");;
        String upper = client.uppercase("hello");
        System.out.println(upper);
    }
}
