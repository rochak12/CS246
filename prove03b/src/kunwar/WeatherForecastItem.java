package kunwar;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeatherForecastItem {
    @SerializedName("main")
    Map<String, Float> measurments;


    List<Weather> weather;
    Map<String, Float> wind;
    String dt_txt;


    public Map<String, Float> getMeasurments() {
        return measurments;
    }

    public void setMeasurments(Map<String, Float> measurments) {
        this.measurments = measurments;
    }

    public List<Weather> getWeather() {
        return weather;
    }
}
