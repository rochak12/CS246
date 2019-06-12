package com.example.android.prove05;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    String _book;
    String _chapter;
    String _verse;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        _book = intent.getStringExtra(MainActivity.BOOK_PART);
        _chapter = intent.getStringExtra(MainActivity.CHAPTER_PART);
        _verse = intent.getStringExtra(MainActivity.VERSE_PART);

        String scripture = String.format("%s %s:%s", _book, _chapter, _verse);

        Log.d(getClass().getName(), String.format("Received intent with %s", scripture));

        TextView scriptureLabel = (TextView) findViewById(R.id.display);
        scriptureLabel.setText(scripture);
    }
}