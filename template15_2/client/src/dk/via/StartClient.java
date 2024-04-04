package dk.via;

import dk.via.exercise11_2.shared.Login;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.Registry;

public class StartClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = null; // get the registry instead
        Login client = null; // get the client from the registry instead
        // Test the client here.
    }
}
