package com.example.android.rochak;

import android.app.Activity;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;

public class DisplayTemp implements Runnable {
    MainActivity mainActivity;
    String city;
    /*TextView display;*/
    WeakReference<MainActivity> weakReference;
    int temp;

    public DisplayTemp(MainActivity mainActivity, String cityName){// , String cityName) {
        this.city = city;
        this.mainActivity = mainActivity;
        weakReference = new WeakReference<>(mainActivity);
        //this.display = display;
    }


    public void run() {
        if (mainActivity == null) {
            mainActivity = (MainActivity) weakReference.get();
        }


        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivity.publishResultFromAPI(6);
            }
        });


  }
}