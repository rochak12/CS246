package com.example.android.prove05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String BOOK_PART = "BOOK_PART";
    public static final String CHAPTER_PART = "CHAPTER_PART";
    public static final String VERSE_PART = "VERSE_PART";


    private EditText enterBook;
    private EditText enterChapter;
    private EditText enterVerse;
    private TextView display;
    private Button findButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterBook = (EditText) findViewById(R.id.enterBook);
        enterChapter = findViewById(R.id.enterChapter);
        enterVerse = findViewById(R.id.enterVerse);
        display = findViewById(R.id.display);
        findButton = findViewById(R.id.findButton);


        final String txtBook = enterBook.getText().toString();
        String txtChapter =  enterChapter.getText().toString();
        String txtVerse = enterVerse.getText().toString();
     //   final String textToDisplay = String.format("%s %s:%s", txtBook, txtChapter, txtVerse);
       final String textToDisplay = txtBook + " " + txtChapter + ":" + txtVerse;



        findButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Perform action on click
                 display.setText(enterBook.getText().toString() + " " + enterChapter.getText().toString() + ":" + enterVerse.getText().toString());

            }         });
    System.out.println(textToDisplay);
    }

}

