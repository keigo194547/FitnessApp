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
       // Button wightButtom = (Button) findViewById(R.id.firstInput);


        // ボタン画面遷移
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), AnyInputScreen.class);
                startActivity(intent);
            }
        });

    }


}