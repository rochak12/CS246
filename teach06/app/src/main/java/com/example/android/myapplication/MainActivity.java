package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void call1st(View view) {
        Even even = new Even(100, this);
        even.start();
    }
    public void call2nd (View view) {
        Odd odd = new Odd(100, this);
        odd.start();
    }
}
