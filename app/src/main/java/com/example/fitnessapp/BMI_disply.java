package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BMI_disply extends AppCompatActivity {

    TextView bmiText,resultBmiText;
    TextView heavyText,resultHeavyText;
    TextView textView;
    Button button;
    Intent intent;

    int resultInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_disply);

        // Widgetの取得
        intent =  getIntent();
        bmiText = (TextView)findViewById(R.id.bmi);
        resultBmiText = (TextView) findViewById(R.id.resultbmi);
        heavyText = (TextView) findViewById(R.id.heavy);
        resultHeavyText = (TextView)findViewById(R.id.resultheavy);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);

        resultInt = intent.getIntExtra("Key3", 0);

        // Widgetの編集
        bmiText.setText("あなたのBMIは");
        heavyText.setText("適性体重は");

        resultBmiText.setText(intent.getStringExtra("Key1"));
        resultHeavyText.setText(intent.getStringExtra("Key2") + "kgだよ");

        if(resultInt >= 18 && resultInt <= 24){
            textView.setText("普通の体形だね");
        }else if(resultInt >= 25){
            textView.setText("太りすぎや、あほんだら");
        }else{
            textView.setText("やせぎみ、もっと肉を食え");
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BMIListInformation.class);
                startActivity(intent);
            }
        });

    }
}