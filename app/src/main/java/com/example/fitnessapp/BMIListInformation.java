package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BMIListInformation extends AppCompatActivity {

    private static final String[] ITEMS = {"重度のやせ","中度のやせ","軽度のやせ",
            "普通","前肥満","肥満(1度)","肥満(2度)","肥満(3度)" };

    ListView setList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmilist_information);

        setContentView(R.layout.activity_bmilist_information);

        ArrayAdapter<String > adapter = new ArrayAdapter<String>(
                this,R.layout.list_layout,ITEMS);

        setList = (ListView) findViewById(R.id.list);

        setList.setAdapter(adapter);








        /*
        String[] comments = {"重度のやせ","中度のやせ","軽度のやせ",
                "普通","前肥満","肥満(1度)","肥満(2度)","肥満(3度)" };
        String[] valueBMI = {"16.0未満","16.0~17.0","17.0~18.5","18.5~25.0",
                "25.0~30.0","30.0~35.0","35以上"};

        List<Map<String,String >> information = new ArrayList<Map<String ,String >>();

        for(int i = 0; i < comments.length; i++){ // データの入力
            Map<String ,String > item = new HashMap<String ,String >();
            item.put("comments", comments[i]);
            item.put("valueBMI",valueBMI[i]);
            information.add(item);
        }

        String[] from = {"comments", "valueBMI"};
        int[] to = {android.R.id.text1, R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                information, R.layout.activity_bmilist_information, from, to);

        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);

         */
    }
}