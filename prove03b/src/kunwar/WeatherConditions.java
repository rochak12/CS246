package kunwar;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class WeatherConditions {
    int id;
    String name;

    @SerializedName("main")
    Map<String, Float> measurments;


    WeatherConditions(int id, String name, Map main){
        this.id = id;
        this.name = name;
        this.measurments = main;
    }


}
