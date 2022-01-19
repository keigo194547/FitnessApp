package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnyInputScreen extends AppCompatActivity {

    TextView tallText,wigthText, resultText;
    static EditText tallEdit,wightEdit;
    Button cialbutton;

    int tnum, wnum = 0;

    public int bmiResult = 0;

    public int matchResult = 0;


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

        cialbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = tallEdit.getText().toString();
                String str2 = wightEdit.getText().toString();

                if(str1.length() >= 1 && str2.length() >= 1){
                    tnum = Integer.parseInt(str1);
                    wnum = Integer.parseInt(str2);
                };

                // 各種値計算
                bmiResult = (int) BMI(tnum, wnum);
                matchResult = (int) ApporopriteWeight(tnum);

                // 受け渡す値
                String res = Integer.toString(bmiResult);
                String matchres = Integer.toString(matchResult);
                int bmiResultInt = bmiResult;
                resultText.setText(res);

                Intent intent = new Intent(getApplicationContext(), BMI_disply.class);
                intent.putExtra("Key1", res);
                intent.putExtra("Key2",matchres);
                intent.putExtra("Key3",bmiResultInt);
                startActivity(intent);
            }
        });
    }

    public float BMI(float tall, float weight){ //BMIの計算
        float calTall = tall / 100;
        float bmi = weight / (calTall * calTall);
        return bmi;
    }

    public float ApporopriteWeight(float tall){ // 適性体重の計算
        float appWeight = 0;
        float apptall = 0;
        apptall = tall / 100;
        appWeight = (apptall * apptall) * 22;
        return appWeight;
    }

}