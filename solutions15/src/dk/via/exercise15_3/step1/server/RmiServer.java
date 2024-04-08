package dk.via.exercise15_3.step1.server;

import dk.via.exercise15_3.step1.RemoteMessageList;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RmiServer implements RemoteMessageList {
    private final ArrayList<String> messageList;


    public RmiServer() {
        messageList = new ArrayList<>();
    }

    @Override
    public String getLastMessage() {
        if (messageList.isEmpty())
            return null;
        else
            return messageList.get(messageList.size() - 1);
    }

    @Override
    public void addMessage(String message) throws RemoteException {
        messageList.add(message);
        System.out.println(message);
    }
}
