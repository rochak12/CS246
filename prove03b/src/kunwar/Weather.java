package kunwar;

public class Weather {
    int id;
    String main;
    String description;
    String icon;

    Weather(int id, String main, String description){
        this.description = description;
        this.id = id;
        this.main = main ;
    }


    public String getDescriptionn() {
        return description;
    }
}
