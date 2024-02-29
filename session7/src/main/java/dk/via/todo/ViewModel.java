package dk.via.todo;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewModel implements PropertyChangeListener {
    private final Model model;
    private final SimpleListProperty<String> todos;
    private final StringProperty todo;

    public ViewModel(Model model) {
        this.todos = new SimpleListProperty<>(FXCollections.observableArrayList(model.getTodos()));
        this.todo = new SimpleStringProperty();
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public void addTodo() {
        if (!todo.isEmpty().get()) {
            model.addTodo(todo.get());
            todo.set("");
        }
    }

    public void bindTodos(ObjectProperty<ObservableList<String>> property) {
        property.bind(todos);
    }

    public void bindTodoCount(StringProperty property) {
        property.bind(Bindings.createStringBinding(() -> String.valueOf(todos.size()), todos));
    }

    public void bindTodo(StringProperty property) {
        property.bindBidirectional(todo);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            todos.setAll(model.getTodos());
        });
    }
}
