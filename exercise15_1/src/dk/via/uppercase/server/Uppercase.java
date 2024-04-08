package dk.via.uppercase.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Uppercase extends Remote {
    String uppercase(String source) throws RemoteException;
}
