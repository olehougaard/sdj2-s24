package dk.via.uppercase.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Locale;

public class UppercaseService extends UnicastRemoteObject implements Uppercase {
    protected UppercaseService() throws RemoteException {
        super(8888);
    }

    @Override
    public String uppercase(String source) {
        return source.toUpperCase(Locale.ROOT);
    }
}
