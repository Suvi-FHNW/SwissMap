package project;

import java.io.*;
import java.util.ArrayList;

public class Model {
    private ArrayList<Canton> cantons;
    private String errorMessage ="Folgende Daten bitte ändern: ";
    private boolean exception;

    public Model() {
        cantons = new ArrayList<>();
        readData();
    }

    private void readData() {
        InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("project/ressources/canton_input.txt");
        String dataString = "";
        String[] data = new String[5];
        try (BufferedReader fileIn = new BufferedReader(new InputStreamReader(inStream))) {
            for (int i = 0; i <= 25; i++) {
                dataString = fileIn.readLine();
                data = dataString.split(";");
                Canton c = new Canton();
                c.setName(data[0]);
                c.setYearOfJoining(Integer.parseInt(data[1]));
                c.setPopulation(Integer.parseInt(data[2]));
                c.setArea(Integer.parseInt(data[3]));
                c.setCapital(data[4]);
                if(data[5].contains("D")) {
                    c.getLanguages().add(Canton.Languages.Deutsch);
                }
                if(data[5].contains("F")) {
                    c.getLanguages().add(Canton.Languages.Französisch);
                }
                if(data[5].contains("I")) {
                    c.getLanguages().add(Canton.Languages.Italienisch);
                }
                if(data[5].contains("R")) {
                    c.getLanguages().add(Canton.Languages.Rätoromanisch);
                }
                cantons.add(c);
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    public void saveData(String name, int yearOfJoining, int population, int area, String capital, ArrayList<Canton.Languages> languages) {
        for (Canton c : cantons) {
            if (c.isActive()) {
                c.setName(name);
                c.setYearOfJoining(yearOfJoining);
                c.setPopulation(population);
                c.setArea(area);
                c.setLanguages(languages);
            }
        }
    }

    public void saveDataToFile() {
        File file = new File("src/project/ressources/canton_input.txt");
        String data = "";
        try (FileWriter fileOut = new FileWriter(file)) {
            for (Canton c : cantons) {
                data = c.getName()+";"+c.getYearOfJoining()+";"+c.getPopulation()+";"+c.getArea()+";"+c.getCapital()+";";
                if (c.getLanguages().contains(Canton.Languages.Deutsch)) {
                    data += "D";
                }
                if(c.getLanguages().contains(Canton.Languages.Französisch)) {
                    data += "F";
                }
                if(c.getLanguages().contains(Canton.Languages.Italienisch)) {
                    data += "I";
                }
                if(c.getLanguages().contains(Canton.Languages.Rätoromanisch)) {
                    data += "R";
                }
                fileOut.write(data+"\n");
                fileOut.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteData() {
        for (Canton c : cantons) {
            if(c.isActive()) {
                c.setYearOfJoining(0);
                c.setPopulation(0);
                c.setArea(0);
                c.setCapital("");
                c.setLanguages(c.resetLanguages());
            };
        }
    }

    public boolean checkEntry(String name, int yearOfJoining, int population, int area, String capital) {
        boolean valid = true;
        if (yearOfJoining < 0 || yearOfJoining > 2021) {
            valid = false;
            if (!errorMessage.contains("Gründungsjahr")) {
                errorMessage += " Gründungsjahr";
            }

        }
        if (population < 0) {
            valid = false;
            if(!errorMessage.contains("Bevölkerung")) {
                errorMessage += " Bevölkerung";
            }


        }
        if (capital.equals("")){
            valid = false;
            if (!errorMessage.contains("Hauptort")){
                errorMessage +=  " Hauptort";
            }
        }
        if (exception) valid = false;
        return valid;
    }

    public ArrayList<Canton> getCantons() {
        return cantons;
    }

    public void setCantons(ArrayList<Canton> cantons) {
        this.cantons = cantons;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isException() {
        return exception;
    }

    public void setException(boolean exception) {
        this.exception = exception;
    }
}