package project;

import java.io.*;
import java.util.ArrayList;

public class Model {
    private ArrayList<Canton> cantons;

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
    public ArrayList<Canton> getCantons() {
        return cantons;
    }

    public void setCantons(ArrayList<Canton> cantons) {
        this.cantons = cantons;
    }
}
