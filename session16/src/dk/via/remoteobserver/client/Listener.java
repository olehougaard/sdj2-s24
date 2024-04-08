package dk.via.remoteobserver.client;

import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remoteobserver.shared.Expression;
import dk.via.remoteobserver.shared.Math;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Step 1: implements RemotePropertyChangeListener<Expression>
// Step 3b: extend UnicastRemoteObject
public class Listener extends UnicastRemoteObject implements RemotePropertyChangeListener<Expression> {
    protected Listener(Math math) throws RemoteException {
        //Step 3
        math.addPropertyChangeListener(this);
    }

    @Override
    // Step 2
    public void propertyChange(RemotePropertyChangeEvent<Expression> event) {
        System.out.println("Server received " + event.getNewValue());
    }
}
