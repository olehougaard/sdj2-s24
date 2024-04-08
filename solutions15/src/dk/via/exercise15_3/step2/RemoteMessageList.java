package dk.via.exercise15_3.step2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote {
    String getLastMessage() throws RemoteException;

    void addMessage(String message, RemoteSender callback) throws RemoteException;
}
