package dk.via.todo;

public class CreateTodos implements Runnable {
    private final Model model;

    public CreateTodos(Model model) {
        this.model = model;
    }

    public void run() {
        try {
            Thread.sleep(3000);
            for(int i = 1; i <= 10; i++) {
                model.addTodo("Todo " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
