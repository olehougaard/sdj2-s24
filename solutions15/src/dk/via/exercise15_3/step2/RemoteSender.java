package dk.via.exercise15_3.step2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteSender extends Remote {
    void replyMessage(String message) throws RemoteException;
}
