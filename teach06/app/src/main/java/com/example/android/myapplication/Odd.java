package com.example.android.myapplication;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Random;

public class Odd extends Thread{
    private int jobsize;
    Activity activity;
    WeakReference<Activity> weakActivity;// = new WeakReference<Activity>(activity);

    public Odd(int jobsize, Activity activity){
        this.jobsize = jobsize;
        this.activity = activity;
        weakActivity = new WeakReference<Activity>(activity);
    }

    public void doJob(){
        Random random = new Random();
        for (int i = 1; i < jobsize; i=i+2) {
            System.out.println("Performing step " + i + "of" + jobsize);
            try{
                Thread.sleep(20);

            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //run on UI thread
        activity = null;

        if (activity == null) {
            //if the activity gets killed then we can do
            activity = weakActivity.get();
        }
        // and it will reference back to Activity instance again
        activity.runOnUiThread(new Runnable(){
        public void  run(){
            Toast toast = Toast.makeText(activity, "Odd counting done", Toast.LENGTH_SHORT);
            toast.show();
        }
    });
    }

    public void run(){
        doJob();
  }



}
