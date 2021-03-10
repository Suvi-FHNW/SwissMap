package project;

import java.util.ArrayList;

public class Model {
    private ArrayList<Canton> cantons;
    private Canton ag;
    private Canton ar;
    private Canton ai;
    private Canton bl;
    private Canton bs;
    private Canton be;
    private Canton fr;
    private Canton ge;
    private Canton gl;
    private Canton gr;
    private Canton ju;
    private Canton lu;
    private Canton ne;
    private Canton nw;
    private Canton ow;
    private Canton sh;
    private Canton sz;
    private Canton so;
    private Canton sg;
    private Canton ti;
    private Canton tg;
    private Canton ur;
    private Canton vd;
    private Canton vs;
    private Canton zg;
    private Canton zh;


    public Model() {
        cantons = new ArrayList<>();

        ag = new Canton("Aargau", 1803, 685424, 1404, "Aarau", null);
        cantons.add(ag);

        ar = new Canton(" Appenzell Ausserrhoden", 1513, 55234, 243, "Herisau", null);
        cantons.add(ar);

        ai = new Canton("Appenzell Innerrhoden", 1513, 16145, 172, "Appenzell", null);
        cantons.add(ai);

        bl = new Canton("Basel-Landschaft", 1501, 288132, 518, "Liestal", null);
        cantons.add(bl);

        bs = new Canton("Basel Stadt", 1501, 194766, 37, "Basel", null);
        cantons.add(bs);

        be = new Canton("Bern", 1353, 1034977, 5960, "Bern", null);
        cantons.add(be);

        fr = new Canton("Freiburg", 1481, 318714, 1671, "Freiburg", null);
        cantons.add(fr);

        ge = new Canton("Genf", 1815, 499480, 282, "Genf", null);
        cantons.add(ge);

        gl = new Canton("Glarus", 1352, 40403, 685 , "Glarus", null);
        cantons.add(gl);

        gr = new Canton("Graubünden", 1803, 198379, 7105, "Chur", null);
        cantons.add(gr);

        ju = new Canton("Jura", 1979, 73419, 839, "Delsberg", null);
        cantons.add(ju);

        lu = new Canton("Luzern", 1332, 409557, 1494, "Luzern", null);
        cantons.add(lu);

        ne = new Canton("Neuenburg", 1815, 176850, 802, "Neuenburg", null);
        cantons.add(ne);

        nw = new Canton("Nidwalden", 1291, 43223, 276, "Stans", null);
        cantons.add(nw);

        ow = new Canton("Obwalden", 1291, 37841, 491, "Sarnen", null);
        cantons.add(ow);

        sh = new Canton("Schaffhausen", 1501, 81991, 298, "Schaffhausen", null);
        cantons.add(sh);

        sz = new Canton("Schwyz", 1291, 159165, 908, "Schwyz", null);
        cantons.add(sz);

        so = new Canton("Solothurn", 1481, 273194, 790, "Solothurn", null);
        cantons.add(so);

        sg = new Canton("St.Gallen", 1803, 507697, 2028, "St.Gallen", null);
        cantons.add(sg);

        ti = new Canton("Tessin", 1803, 353343, 2812, "Bellinzona", null);
        cantons.add(ti);

        tg = new Canton("Thurgau", 1803, 276472, 994, "Frauenfeld", null);
        cantons.add(tg);

        ur = new Canton("Uri", 1291, 36433, 1077, "Altdorf", null);
        cantons.add(ur);

        vd = new Canton("Waadt", 1803, 799145, 3212, "Lausanne", null);
        cantons.add(vd);

        vs = new Canton("Wallis", 1815, 343955, 5225, "Sitten", null);
        cantons.add(vs);

        zg = new Canton("Zug", 1352, 126837, 239, "Zug", null);
        cantons.add(zg);

        zh = new Canton("Zürich", 1351, 1520968, 1729, "Zürich", null);
        cantons.add(zh);
    }

    public ArrayList<Canton> getCantons() {
        return cantons;
    }

    public void setCantons(ArrayList<Canton> cantons) {
        this.cantons = cantons;
    }
}
