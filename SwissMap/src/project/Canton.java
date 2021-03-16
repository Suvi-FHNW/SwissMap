package project;

import java.util.ArrayList;

public class Canton {

    public enum Languages {Deutsch, Französisch, Italienisch, Rätoromanisch};

    private String name;
    private int yearOfJoining;
    private int population;
    private int area;
    private String capital;
    private ArrayList<Languages> languages;
    private boolean active = false;


    public Canton() {
        languages = new ArrayList<>();
    }

    public ArrayList<Languages> resetLanguages() {
        languages = new ArrayList<>();
        return languages;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public ArrayList<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Languages> languages) {
        this.languages = languages;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}