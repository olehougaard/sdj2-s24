package dk.via.exercise6_1.viewmodel;

import dk.via.exercise6_1.model.Model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogViewModel implements PropertyChangeListener {
    private final Model model;
    private final SimpleListProperty<String> logs;

    public LogViewModel(Model model) {
        this.model = model;
        this.logs = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.model.addPropertyChangeListener(this);
    }

    public void bindLogs(ObjectProperty<ObservableList<String>> property) {
        //Unidirectional
        property.bind(logs);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logs.setAll(model.getHistory());
    }
}
