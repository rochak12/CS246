package com.example.android.myapplication;

import android.app.Activity;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Random;

public class Even extends Thread{

    private int jobsize;
    Activity activity;
    WeakReference<Activity> weakActivity;// = new WeakReference<Activity>(activity);


    public Even(int jobsize, MainActivity activity){
        this.jobsize = jobsize;
        this.activity = activity;
        weakActivity = new WeakReference<Activity>(activity);
    }

    public void doJob() {
        Random random = new Random();
        for (int i = 0; i < jobsize; i = i + 2) {
            try {
                Thread.sleep(250);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Performing step " + i + "of" + jobsize);
        }

        activity = null;

        if (activity == null) {
            //if the activity gets killed then we can do
            activity =  weakActivity.get();
        }

        activity.runOnUiThread(new Runnable(){
            public void  run(){
                Toast toast = Toast.makeText(activity, "Even counting done", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void run(){
        doJob();
    }




}
