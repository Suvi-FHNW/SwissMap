package project;

import java.util.ArrayList;

public class Model {
    private ArrayList<Canton> cantons;
    private Canton aargau;
    private Canton baselStadt;

    public Model() {
        cantons = new ArrayList<>();
        aargau = new Canton("Aargau", 1803, 685424, 0, null, null);
        baselStadt = new Canton("Basel Stadt", 0, 0, 0, null, null);
        cantons.add(aargau);
        cantons.add(baselStadt);
    }

    public ArrayList<Canton> getCantons() {
        return cantons;
    }

    public void setCantons(ArrayList<Canton> cantons) {
        this.cantons = cantons;
    }
}
