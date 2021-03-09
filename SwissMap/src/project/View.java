package project;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
    private Stage stage;
    private Model model;

    private Pane root;
    private VBox boxOverview;
    private GridPane gridDetails;

    private Label swissCantons;
    private Label cantonName;


    public View(Stage stage, Model model) {
        this.stage = stage;
        this.model = model;

        root = new Pane();

        setRootCenter();
        setRootLeft();
        setRootRight();

        Scene scene = new Scene(root, 1300, 600);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("project/ressources/swissFlag.png")));
        stage.setScene(scene);
        stage.setTitle("Swiss Map");

    }
    protected void start() {
        stage.show();
    }

    private void setRootLeft() {
        boxOverview = new VBox();
        swissCantons = new Label("Die Kantone der Schweiz");
        swissCantons.getStyleClass().add("title");
        boxOverview.setMaxWidth(300);
        boxOverview.getChildren().add(swissCantons);

        for (int i = 0; i < model.getCantons().size(); i++) {
            Label l = new Label(model.getCantons().get(i).getName());
            boxOverview.getChildren().add(l);
        }
        root.getChildren().add(boxOverview);
        boxOverview.setTranslateY(20);
        boxOverview.setTranslateX(50);
    }
    // TODO just for concept, needs to be refined
    private void setRootCenter() {
        gridDetails = new GridPane();
        Label name = new Label(model.getCantons().get(0).getName());
        gridDetails.add(name, 0, 0);
        Label population = new Label("Population");
        Label populationData = new Label("34353");
        gridDetails.add(population, 0, 1);
        gridDetails.add(populationData, 1, 1);
        gridDetails.setGridLinesVisible(true);
        root.getChildren().add(gridDetails);
        gridDetails.setTranslateX(500);
        gridDetails.setTranslateY(20);
    }

    private void setRootRight() {
        Image map = new Image(getClass().getClassLoader().getResourceAsStream("project/ressources/KarteMitWappen.png"));
        ImageView imgMap = new ImageView(map);
        root.getChildren().add(imgMap);
        imgMap.setTranslateX(700);
        imgMap.setTranslateY(20);
    }

}
