package dk.via.todo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final ArrayList<String> todos;
    private final PropertyChangeSupport support;

    public Model() {
        todos = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }

    public void addTodo(String todo) {
        todos.add(todo);
        support.firePropertyChange("addTodo", null, todo);
    }

    public List<String> getTodos() {
        return new ArrayList<>(todos);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
