package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RecodeToSqlite extends AppCompatActivity {

    private Button bt1,bt2;
    private EditText et;
    private TextView tv,recodetv;
    private DBHelper dbhelper;
    private String str;
    private int num = 0;
    private static SQLiteDatabase db;
    Intent intent;
    String _timerResult;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        bt1 = new Button(this);
        bt1.setText("追加");
        bt1.setOnClickListener(new ExSampleClickListener());
        bt2 = new Button(this);
        bt2.setText("削除");
        bt2.setOnClickListener(new ExSampleClickListener());

        ll.addView(bt1);
        ll.addView(bt2);

        intent =  getIntent();
        _timerResult = intent.getStringExtra("time");

        System.out.println("===========================================================");
        System.out.println(_timerResult);

        //et = new EditText(this);
        recodetv = new TextView(this);
        tv = new TextView(this);
        recodetv.setText(_timerResult);
        tv.setText("データベース一覧\n");

        //recodetv.setText(_timerResult);
        //ll.addView(et);
        ll.addView(recodetv);
        ll.addView(tv);

        dbhelper = new DBHelper(this);  //データベースヘルパークラスの生成

        db = dbhelper.getWritableDatabase();  //データベースの作成 or オープン



        db.delete("sampletable", null, null);  //データベースのリセット
    }

    class ExSampleClickListener implements View.OnClickListener {
        @SuppressLint("Range")
        public void onClick(View v) {
            ContentValues values = new ContentValues();  //データベースに入力するデータを保存するためのオブジェクトの生成

            if(v == bt1) {
                values.put("sampletext",recodetv.getText().toString());  //エディットテキストからデータベースに入力する値を取得
                db.insert("sampletable", null, values);  //データベースに値を挿入
                num++;  //リストのナンバーをインクリメント
            }
            else if(v == bt2) {
                String[] args = {String.valueOf(num)};  //リストの最後の番号を取得
                db.delete("sampletable", "_id = ?", args);  //リストの最後の値を削除
                num--;  //リストのナンバーをデクリメント
            }

            Cursor cr = db.query(
                    "sampletable", new String[]{"_id", "sampletext"},
                    null, null, null,
                    null, null);  //クエリ結果をカーソルで取得

            str = "データベース一覧\n";
            while (cr.moveToNext()) {  //カーソルを一つづつ動かしてデータ取得
                str += cr.getString(cr.getColumnIndex("_id")) + ":" +
                        cr.getString(cr.getColumnIndex("sampletext")) + "\n";
            }
            tv.setText(str);

        }
    }

}