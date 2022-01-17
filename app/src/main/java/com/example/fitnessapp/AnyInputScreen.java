package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnyInputScreen extends AppCompatActivity {

    TextView tallText,wigthText, resultText;
    static EditText tallEdit,wightEdit;
    Button cialbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_any_input_screen);

        tallText = (TextView) findViewById(R.id.tall);
        wigthText = (TextView) findViewById(R.id.weight);
        resultText = (TextView) findViewById(R.id.result);

        tallEdit = (EditText) findViewById(R.id.editTextTextTall);
        wightEdit = (EditText)findViewById(R.id.editTextTextWeight);

        cialbutton = (Button) findViewById(R.id.calButton);

        String str1 = tallEdit.getText().toString();
        String str2 = wightEdit.getText().toString();

        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);

        int result = num1 + num2;
        resultText.setText(result);




        cialbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }


    public float BMI(int tall, int weight){
        float bmi = 0;
        tall = tall / 10;
        bmi = weight / tall * tall;
        return bmi;
    }

    public float ApporopriteWeight(int tall, int weight){
        float appweight = 0;
        tall = tall / 10;
        appweight = (tall*tall)*22;
        return appweight;
    }


}