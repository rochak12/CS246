package kunwar;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   static URL url1;
   static URL url2;
   static WeatherConditions weatherConditions;

    private static void buildURL1(String city) {
        try {
            url1 = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=b4d4258c3f3876775b39421c51a5c7ff&units=metric");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void buildURL2(String city){
        try {
            System.out.println("https://samples.openweathermap.org/data/2.5/forecast?id=" + weatherConditions.id + "&appid=b6907d289e10d714a6e88b30761fae22");
            url2 = new URL("https://samples.openweathermap.org/data/2.5/forecast?id=" + weatherConditions.id + "&appid=b6907d289e10d714a6e88b30761fae22");
             } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static URL buildURLList(String city){
        try {
            return new URL("https://samples.openweathermap.org/data/2.5/forecast?id=" + weatherConditions.id + "&appid=b6907d289e10d714a6e88b30761fae22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }


    static String getCity(){
        System.out.print("Enter a city name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void printForecast(WeatherForecast weatherForecast) {
        for(WeatherForecastItem item : weatherForecast.weatherForecastItemList){
            System.out.println(item.dt_txt);
            System.out.println(item.getMeasurments().get("temp"));
            System.out.println(item.getWeather().get(0).description);
            System.out.println(item.wind.get("speed"));

        }

    }


    public static void main(String[] args) throws IOException {
         String city  = getCity();
        buildURL1(city);

        String jsonstring = getResponseFromHttpUrl(url1); // returns back the whole JSON string
        Gson gson = new Gson();
        weatherConditions = gson.fromJson(jsonstring, WeatherConditions.class);
        System.out.print(weatherConditions.id);
        System.out.print(weatherConditions.name);
        System.out.print(weatherConditions.measurments);

        buildURL2(city);
        String jsonString2 = getResponseFromHttpUrl(url2);
        WeatherForecast weatherForecast = gson.fromJson(jsonString2, WeatherForecast.class);
        printForecast(weatherForecast);

//        List<String> cityList = new ArrayList<>();
//        cityList.add(city);
//        cityList.add("toronto");
//        cityList.add("hongkong");
//        cityList.add("belgium");
//        cityList.add("kathmandu");
//
//        List<URL> urlList = null;
//        for (String cityName : cityList){
//            urlList.add(buildURLList(cityName));
//        }
//
//        List<String> json = null;
//        for (URL url : urlList){
//            json.add(getResponseFromHttpUrl(url));
//        }




    }
}
