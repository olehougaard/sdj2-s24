package dk.via.accounts.model;

import java.beans.PropertyChangeListener;

public interface UserModel {
    void addUser(String username, String password, String email) throws IllegalArgumentException, IllegalStateException;

    User getUser(String username);

    User getLastUser();

    int getUserCount();

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
