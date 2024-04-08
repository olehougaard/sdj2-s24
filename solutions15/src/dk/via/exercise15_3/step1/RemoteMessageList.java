package dk.via.exercise15_3.step1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote {
    String getLastMessage() throws RemoteException;

    void addMessage(String message) throws RemoteException;
}
