package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 画面遷移
        Button inputButton = (Button) findViewById(R.id.firstInput);
        Button wightButtom = (Button) findViewById(R.id.ListBMI);
        Button timerButtom = (Button) findViewById(R.id.timerButton);

        // ボタン画面遷移
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), AnyInputScreen.class);
                startActivity(intent);
            }
        });

        wightButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BMIListInformation.class);
                startActivity(intent);
            }
        });

        timerButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TimerScreen.class);
                startActivity(intent);
            }
        });


    }


}