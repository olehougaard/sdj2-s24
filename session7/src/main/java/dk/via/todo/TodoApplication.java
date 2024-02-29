package dk.via.todo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TodoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TodoApplication.class.getResource("hello-view.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        initMVVM(fxmlLoader);
    }

    private void initMVVM(FXMLLoader fxmlLoader) {
        ViewController controller = fxmlLoader.getController();
        Model model = new Model();
        ViewModel viewModel = new ViewModel(model);
        controller.init(viewModel);
        CreateTodos createTodos = new CreateTodos(model);
        Thread thread = new Thread(createTodos);
        thread.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
