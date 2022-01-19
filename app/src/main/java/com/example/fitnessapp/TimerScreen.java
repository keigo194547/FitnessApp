package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.view.View;

public class TimerScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_screen);

        ((Chronometer)findViewById(R.id.chronometer)).start();

    }

    public void onStart( View v ){
        ((Chronometer)findViewById(R.id.chronometer)).setBase(SystemClock.elapsedRealtime());
        ((Chronometer)findViewById(R.id.chronometer)).start();
    }

    // ストップ
    public void onStop( View v ){
        ((Chronometer)findViewById(R.id.chronometer)).stop();
    }

}