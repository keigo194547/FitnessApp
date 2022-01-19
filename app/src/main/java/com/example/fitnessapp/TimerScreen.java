package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;

// 定期処理するためのメソッド仕様宣言
public class TimerScreen extends AppCompatActivity implements Chronometer.OnChronometerTickListener {

    int x = 0;
    int getX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_screen);

        ((Chronometer)findViewById(R.id.chronometer)).start();

        Button recodeButton = (Button) findViewById(R.id.recode);

        recodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), RecodeToSqlite.class);

                String res = Integer.toString(getX);
                //System.out.println(res);
                intent.putExtra("time",res);
                startActivity(intent);
            }
        });

        System.out.println(x);
    }

    public void onStart( View v ){
        ((Chronometer)findViewById(R.id.chronometer)).setBase(SystemClock.elapsedRealtime());
        ((Chronometer)findViewById(R.id.chronometer)).start();

        ((Chronometer)findViewById(R.id.chronometer)).setOnChronometerTickListener(this);

        x = 0; //timeをそのまま増やさないように
    }

    // ストップ
    public void onStop( View v ){
        ((Chronometer)findViewById(R.id.chronometer)).stop();
        ((ImageView)findViewById(R.id.iv)).setImageResource(R.drawable.musle);
        // System.out.println(getX);
    }

    // 定期的処理② 約１秒毎に実行する具体的処理
    @Override
    public void onChronometerTick(Chronometer chronometer) {
        // 条件分析
        x++;    // xを+1させる
        if( x % 2 ==0 ) {   // 偶数ですか？
            // YESの場合
            ((ImageView) findViewById(R.id.iv)).setImageResource(R.drawable.cute1);
        }else {
            // NOの場合
            ((ImageView) findViewById(R.id.iv)).setImageResource(R.drawable.cute2);
        }
        getX = x;

    }
}