package project;

public class Canton {
    private String name;
    private int yearOfJoining;
    private int population;
    private double area;
    private String capital;
    private String flag;

    public Canton(String name, int yearOfJoining, int population, int area, String capital, String flag) {
        this.name = name;
        this.yearOfJoining = yearOfJoining;
        this.population = population;
        this.area = area;
        this.capital = capital;
        this.flag = flag;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
