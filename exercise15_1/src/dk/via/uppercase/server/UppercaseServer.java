package dk.via.uppercase.server;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class UppercaseServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);
        UppercaseService service = new UppercaseService();
        Remote object = UnicastRemoteObject.exportObject(service, 8888);
        registry.bind("uppercase", object);
        System.out.println("Server started");
    }
}
