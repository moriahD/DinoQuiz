package com.example.android.dinoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startButton(View v){
        //Go to next quiz page when 'Let's start' button is clicked
        Button button=(Button) v;
        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
    }

}
