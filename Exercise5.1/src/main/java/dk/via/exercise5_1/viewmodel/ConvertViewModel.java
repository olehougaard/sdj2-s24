package dk.via.exercise5_1.viewmodel;

import dk.via.exercise5_1.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConvertViewModel {
    private final Model model;
    private final StringProperty request;
    private final StringProperty reply;
    private final StringProperty error;

    public ConvertViewModel(Model model) {
        this.model = model;
        request = new SimpleStringProperty();
        reply = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    public void convert() {
        try {
            String converted = model.convert(request.get());
            reply.set(converted);
            error.set("");
        } catch (Exception e) {
            error.set(e.getMessage());
        }
    }

    public void bindRequest(StringProperty property) {
        request.bindBidirectional(property);
    }

    public void bindReply(StringProperty property) {
        reply.bind(property);
    }

    public void bindError(StringProperty property) {
        error.bind(property);
    }
}
