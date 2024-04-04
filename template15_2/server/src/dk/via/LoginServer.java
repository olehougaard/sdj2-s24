package dk.via;

import java.rmi.Remote;
import java.rmi.registry.Registry;

public class LoginServer {
    public static void main(String[] args) throws Exception {
        Registry registry = null; // Create registry instead
        LoginImplementation login = new LoginImplementation();
        Remote remote = null; // Create server stub instead
        // Bind name to registry here
        System.out.println("Server running");
    }
}
