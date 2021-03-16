package project;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class View {
    private Stage stage;
    private Model model;

    private Pane root;
    private VBox boxOverview;
    private GridPane gridDetails;

    private Label swissCantons;
    private ArrayList<Label> cantonChoice = new ArrayList<>();
    private ScrollPane paneCantonChoice;
    private VBox boxCantonChoice;

    private Label lblName;
    private Label languages;
    private Label dataYearOfJoining;
    private Label dataPopulation;
    private Label dataArea;
    private Label dataCapital;
    private Label dataLanguages;

    private Button btnEdit;
    private Button btnMap;
    private Button btnDelete;
    private Button btnSave = new Button("Speichern");

    private Alert editWindow = new Alert(Alert.AlertType.NONE);
    private TextField tfName = new TextField();
    private TextField tfYearOfJoining = new TextField();
    private TextField tfPopulation = new TextField();
    private TextField tfArea = new TextField();
    private TextField tfCapital = new TextField();
    private TextField tfLanguage = new TextField("Bitte Komma-getrennt ohne Abstand eingeben");
    private CheckBox checkBoxGerman = new CheckBox("Deutsch");
    private CheckBox checkBoxFrench = new CheckBox("Französisch");
    private CheckBox checkBoxItalian = new CheckBox("Italienisch");
    private CheckBox checkBoxRumantsch = new CheckBox("Rumantsch");


    public View(Stage stage, Model model) {
        this.stage = stage;
        this.model = model;

        root = new Pane();

        root.getChildren().add(setRootLeft());
        root.getChildren().add(setRootCenter());
        root.getChildren().add(setRootBottom());
        setBackgroundImage();

        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("project/ressources/swissFlag.png")));
        stage.setScene(scene);
        stage.setTitle("Schweizer Kantone");
    }

    private void setBackgroundImage() {
        BackgroundImage myBG = new BackgroundImage(new Image(getClass().getClassLoader().getResourceAsStream("project/ressources/background_white.jpg")), null, null, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBG));
    }

    protected void start() {
        stage.show();
    }

    private VBox setRootLeft() {
        boxOverview = new VBox(20);
        paneCantonChoice = new ScrollPane();
        boxCantonChoice = new VBox();
        swissCantons = new Label("Die Kantone der Schweiz");
        swissCantons.getStyleClass().add("title");
        boxOverview.setMaxWidth(500);
        boxOverview.getChildren().add(swissCantons);

        for (int i = 0; i < model.getCantons().size(); i++) {
            Label l = new Label(model.getCantons().get(i).getName());
            l.setMinWidth(300);
            cantonChoice.add(l);
            l.getStyleClass().add("list-content");
        }
        boxCantonChoice.getChildren().addAll(cantonChoice);
        boxCantonChoice.setId("boxCantonChoice");
        paneCantonChoice.setContent(boxCantonChoice);
        paneCantonChoice.setMaxHeight(435);
        paneCantonChoice.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        paneCantonChoice.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        paneCantonChoice.setId("scrollpane");
        boxOverview.getChildren().add(paneCantonChoice);
        boxOverview.setTranslateY(20);
        boxOverview.setTranslateX(50);
        return boxOverview;
    }

    private GridPane setRootCenter() {
        gridDetails = new GridPane();
        gridDetails.setId("portrait");
        lblName = new Label("Bitte wählen Sie einen \nKanton aus der Liste");
        lblName.setId("name");
        lblName.setMinWidth(350);
        Label yearOfJoining = new Label("Gründungsjahr: ");
        Label population = new Label("Bevölkerung: ");
        Label area = new Label("Fläche (in km2): ");
        Label capital = new Label("Hauptort:");
        languages = new Label("Amtssprachen");
        dataYearOfJoining = new Label();
        dataPopulation = new Label();
        dataArea = new Label();
        dataCapital = new Label();
        dataLanguages = new Label();
        gridDetails.add(lblName, 0, 0);
        gridDetails.add(yearOfJoining, 0, 1);
        gridDetails.add(population, 0, 2);
        gridDetails.add(area, 0, 3);
        gridDetails.add(capital, 0, 4);
        gridDetails.add(languages, 0, 5);
        gridDetails.add(dataYearOfJoining, 1, 1);
        gridDetails.add(dataPopulation, 1, 2);
        gridDetails.add(dataArea, 1, 3);
        gridDetails.add(dataCapital, 1, 4);
        gridDetails.add(dataLanguages, 1, 5);

        gridDetails.setTranslateX(440);
        gridDetails.setTranslateY(20);
        return gridDetails;
    }

    private HBox setRootBottom() {
        HBox btm = new HBox(10);
        btnEdit = new Button("Daten bearbeiten");
        btnMap = new Button("Karte anzeigen");
        btnDelete = new Button("Daten löschen");
        btm.getChildren().addAll(btnMap, btnEdit, btnDelete);
        btm.setTranslateX(460);
        btm.setTranslateY(480);
        return btm;
    }

    private void createFlag(String name) {
        String url = "project/ressources/"+name+".jpg";
        Image img = new Image(url);
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(100);
        imgView.setPreserveRatio(true);
        if(gridDetails.getChildren().contains(imgView)) {
            gridDetails.getChildren().remove(imgView);
            gridDetails.add(imgView, 1, 0);
        } else {
            gridDetails.add(imgView, 1, 0);
        }
    }

    public void showMap() {
        Alert map = new Alert(Alert.AlertType.CONFIRMATION);
        map.setTitle("Karte der Schweiz");
        map.setHeaderText("Karte der Schweiz");
        Image img = new Image(getClass().getClassLoader().getResourceAsStream("project/ressources/KarteMitWappen.png"));
        ImageView imgMap = new ImageView(img);
        imgMap.setFitHeight(500);
        imgMap.setPreserveRatio(true);
        map.getDialogPane().setContent(imgMap);
        map.show();
    }

    public void openEdit() {
        GridPane editableInfo = new GridPane();
        Label name = new Label("Name");
        Label yearOfJoining = new Label("Gründungsjahr: ");
        Label population = new Label("Bevölkerung: ");
        Label area = new Label("Fläche (in km2): ");
        Label capital = new Label("Hauptort:");
        Label languages = new Label("Amtssprachen");
        Region spacer = new Region();
        spacer.setMinHeight(20);
        tfName.setText(lblName.getText());
        tfName.setEditable(false);
        tfArea.setText(dataArea.getText());
        tfPopulation.setText(dataPopulation.getText());
        tfYearOfJoining.setText(dataYearOfJoining.getText());
        tfCapital.setText(dataCapital.getText());

        if(dataLanguages.getText().contains("Deutsch")) {
            checkBoxGerman.setSelected(true);
        } else {
            checkBoxGerman.setSelected(false);
        }
        if(dataLanguages.getText().contains("Französisch")) {
            checkBoxFrench.setSelected(true);
        } else {
            checkBoxFrench.setSelected(false);
        }
        if(dataLanguages.getText().contains("Italienisch")) {
            checkBoxItalian.setSelected(true);
        } else {
            checkBoxItalian.setSelected(false);
        }
        if(dataLanguages.getText().contains("Rätoromanisch")) {
            checkBoxRumantsch.setSelected(true);
        } else {
            checkBoxRumantsch.setSelected(false);
        }

        HBox boxLanguages = new HBox(10);
        boxLanguages.getChildren().addAll(checkBoxGerman, checkBoxFrench, checkBoxItalian, checkBoxRumantsch);

        editableInfo.add(name, 0, 0);
        editableInfo.add(yearOfJoining, 0, 1);
        editableInfo.add(population, 0, 2);
        editableInfo.add(area, 0, 3);
        editableInfo.add(capital, 0, 4);
        editableInfo.add(languages, 0, 5);
        editableInfo.add(tfName, 1, 0);
        editableInfo.add(tfYearOfJoining, 1, 1);
        editableInfo.add(tfPopulation, 1, 2);
        editableInfo.add(tfArea, 1, 3);
        editableInfo.add(tfCapital, 1, 4);
        editableInfo.add(boxLanguages, 1, 5);
        editableInfo.add(spacer, 0, 6);
        editableInfo.add(btnSave, 0, 7);

        editableInfo.setId("editable-info");

        tfLanguage.setMinWidth(500);

        editWindow.setTitle("Eintrag bearbeiten");
        editWindow.setHeaderText("Die Daten können in den Textfeldern eingetragen werden");
        editWindow.getDialogPane().setContent(editableInfo);
        if(!editWindow.getDialogPane().getButtonTypes().contains(ButtonType.CLOSE)) {
            editWindow.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        }
        editWindow.show();
    }

    public void updateDetails(String name) {
        for (Canton c : model.getCantons()) {
            if (c.getName().equals(name)) {
                lblName.setText(c.getName());
                createFlag(c.getName().toLowerCase());
                dataPopulation.setText(String.valueOf(c.getPopulation()));
                dataArea.setText(String.valueOf(c.getArea()));
                dataYearOfJoining.setText(String.valueOf(c.getYearOfJoining()));
                dataCapital.setText(c.getCapital());

                String textLang = "";
                String s = "Amtssprachen";
                for (Canton.Languages l : c.getLanguages()) {
                    textLang += l.toString();
                    textLang += "\n";
                    s += "\n ";
                }
                languages.setText(s);
                dataLanguages.setText(textLang);
                c.setActive(true);
            }
        }
    }

    public ArrayList<Label> getCantonChoice() {
        return cantonChoice;
    }

    public void setCantonChoice(ArrayList<Label> cantonChoice) {
        this.cantonChoice = cantonChoice;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    public Button getBtnMap() {
        return btnMap;
    }

    public void setBtnMap(Button btnMap) {
        this.btnMap = btnMap;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    public Alert getEditWindow() {
        return editWindow;
    }

    public void setEditWindow(Alert editWindow) {
        this.editWindow = editWindow;
    }

    public Pane getRoot() {
        return root;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Label getLblName() {
        return lblName;
    }

    public void setLblName(Label lblName) {
        this.lblName = lblName;
    }

    public TextField getTfName() {
        return tfName;
    }

    public void setTfName(TextField tfName) {
        this.tfName = tfName;
    }

    public TextField getTfYearOfJoining() {
        return tfYearOfJoining;
    }

    public void setTfYearOfJoining(TextField tfYearOfJoining) {
        this.tfYearOfJoining = tfYearOfJoining;
    }

    public TextField getTfPopulation() {
        return tfPopulation;
    }

    public void setTfPopulation(TextField tfPopulation) {
        this.tfPopulation = tfPopulation;
    }

    public TextField getTfArea() {
        return tfArea;
    }

    public void setTfArea(TextField tfArea) {
        this.tfArea = tfArea;
    }

    public TextField getTfCapital() {
        return tfCapital;
    }

    public void setTfCapital(TextField tfCapital) {
        this.tfCapital = tfCapital;
    }

    public TextField getTfLanguage() {
        return tfLanguage;
    }

    public void setTfLanguage(TextField tfLanguage) {
        this.tfLanguage = tfLanguage;
    }

    public CheckBox getCheckBoxGerman() {
        return checkBoxGerman;
    }

    public void setCheckBoxGerman(CheckBox checkBoxGerman) {
        this.checkBoxGerman = checkBoxGerman;
    }

    public CheckBox getCheckBoxFrench() {
        return checkBoxFrench;
    }

    public void setCheckBoxFrench(CheckBox checkBoxFrench) {
        this.checkBoxFrench = checkBoxFrench;
    }

    public CheckBox getCheckBoxItalian() {
        return checkBoxItalian;
    }

    public void setCheckBoxItalian(CheckBox checkBoxItalian) {
        this.checkBoxItalian = checkBoxItalian;
    }

    public CheckBox getCheckBoxRumantsch() {
        return checkBoxRumantsch;
    }

    public void setCheckBoxRumantsch(CheckBox checkBoxRumantsch) {
        this.checkBoxRumantsch = checkBoxRumantsch;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }
}
