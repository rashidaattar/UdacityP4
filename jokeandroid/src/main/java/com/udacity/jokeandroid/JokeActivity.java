package com.udacity.jokeandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView textView= (TextView) findViewById(R.id.text1);
        if(getIntent().hasExtra("joke")){
            textView.setText(getIntent().getStringExtra("joke"));
        }
        else{
            textView.setText("Something went wrong there!!!!");
        }
    }
}
