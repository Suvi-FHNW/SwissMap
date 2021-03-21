package project;

import javafx.scene.control.Label;

import java.util.ArrayList;

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

        view.getBtnSave().setOnAction(e -> {
            String name = view.getTfName().getText();
            String errorMessage = model.getErrorMessage();
            model.setException(false);
            int yearOfJoining = 0;
            try {
                yearOfJoining = Integer.parseInt(view.getTfYearOfJoining().getText());
            } catch (NumberFormatException exception) {
                if (!errorMessage.contains("Gründungsjahr")) {
                    errorMessage += " Gründungsjahr";
                }
                model.setException(true);
            }
            int population = 0;
            try {
                population = Integer.parseInt(view.getTfPopulation().getText());
            } catch (NumberFormatException exception) {
                if (!errorMessage.contains("Bevölkerung")) {
                    errorMessage += " Bevölkerung";
                }
                model.setException(true);
            }
            int area = 0;
            try {
                area =  Integer.parseInt(view.getTfArea().getText());
            } catch (NumberFormatException exception) {
                if (!errorMessage.contains("Fläche")) {
                    errorMessage += " Fläche";
                }
                model.setException(true);
            }

            model.setErrorMessage(errorMessage);

            String capital = view.getTfCapital().getText();
            ArrayList<Canton.Languages> lang = new ArrayList<>();
            if (view.getCheckBoxGerman().isSelected()) {
                lang.add(Canton.Languages.Deutsch);
            }
            if (view.getCheckBoxFrench().isSelected()) {
                lang.add(Canton.Languages.Französisch);
            }
            if (view.getCheckBoxItalian().isSelected()) {
                lang.add(Canton.Languages.Italienisch);
            }
            if (view.getCheckBoxRumantsch().isSelected()) {
                lang.add(Canton.Languages.Rätoromanisch);
            }

            if(model.checkEntry(name, yearOfJoining, population, area, capital)) {
                model.saveData(name, yearOfJoining, population, area, capital, lang);
                view.showSaveAlert();
            } else {
                view.showErrorAlert();
            }

            for (Canton c : model.getCantons()) {
                if (c.isActive()) {
                    view.updateDetails(c.getName());
                }
            }
        });

        view.getBtnDelete().setOnAction(e -> {
            model.deleteData();
            for (Canton c : model.getCantons()) {
                if (c.isActive()) {
                    view.updateDetails(c.getName());
                }
            }
        });

        view.getStage().setOnCloseRequest(e -> {
            //TODO Create Alert and ask User if he wants to save data in file
            view.showCloseAlert(e);
            model.saveDataToFile();
        });

    }
}
