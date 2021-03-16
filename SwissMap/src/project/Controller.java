package project;

import javafx.scene.control.Label;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        view.getBtnMap().setOnAction(e -> {
            view.showMap();
        });

        view.getBtnEdit().setOnAction(e -> {
            view.openEdit();
        });

        for (Label l : view.getCantonChoice()) {
            l.setOnMouseClicked(e -> {
                view.updateDetails(l.getText());
            });
        }

        view.getLblName().textProperty().addListener((observable, oldValue, newValue) -> {
            for (Canton c : model.getCantons()) {
                if (c.getName().equals(oldValue)) {
                    c.setActive(false);
                }
            }
        });

    }
}

