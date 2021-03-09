package project;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;
    private View view;
    private Model model;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.model = new Model();
        this.view = new View(primaryStage, model);
        this.controller = new Controller(view, model);
        view.start();
    }
}
