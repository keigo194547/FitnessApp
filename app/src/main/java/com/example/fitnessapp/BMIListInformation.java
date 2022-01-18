package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
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
    static final String[] comments = {"重度のやせ","中度のやせ","軽度のやせ",
            "普通","前肥満","肥満(1度)","肥満(2度)","肥満度(3度)"};
    static final String[] valueBMI = {"16.0未満","16.0~17.0","17.0~18.5","18.5~25.0",
            "25.0~30.0","30.0~35.0","35.0~40.0", "40以上"};

    ListView setList;

    ArrayList<Map<String,String>> list = new ArrayList<Map<String,String>>();
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmilist_information);

        setList = (ListView) findViewById(R.id.BMIList);

        for(int i = 0; i < comments.length; i++){
            Map<String, String> data = new HashMap<String,String>();
            data.put("title", comments[i]);
            data.put("explain", valueBMI[i]);
            list.add(data);
        }

        adapter = new SimpleAdapter(
                this,
                list,
                R.layout.list_layout,
                new String[] {"title","explain"},
                new int[] {R.id.title,R.id.explain}
        );

        setList.setAdapter(adapter);

        /*


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