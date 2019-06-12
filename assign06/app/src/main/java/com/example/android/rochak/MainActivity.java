package com.example.android.rochak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button tempButton;
    Button forecastButton;
    EditText city;
    TextView display;

    String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempButton = findViewById(R.id.buttonForTemp);
        forecastButton = findViewById(R.id.buttonForForecast);
        city = findViewById(R.id.city);
        cityName = String.valueOf(city.getText());
        display = findViewById(R.id.textView);
    }


        public void displayTemp(View view) throws InterruptedException {
//           display.setText("Temp");
//           Thread.sleep(1000);

            Log.i("MainActivity","Getting weather for city: " + city);

           DisplayTemp displayTemp = new DisplayTemp(this, cityName);//, display);
           Thread t = new Thread(displayTemp);
           t.start();
    }

    public void displayForecast(View view) {
        display.setText("Forecast");
    }

    public void publishResultFromAPI(int temp){
        display.setText(Integer.toString(temp));
    }

}
