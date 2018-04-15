package com.example.abhi.timetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    int position = 10;

    public void timeTable(int position) {

        // List View

        listView = findViewById(R.id.myListView);

        ArrayList<Integer> tables = new ArrayList<>();


        for(int i = 1; i <= 10; i++) {  // ArrayList create -  size 1 to 10
            tables.add(i*position);
        }


        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, tables);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SeekBar
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(position);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                if (progress < min) {
                    position = min;
                    seekBar.setProgress(min);
                } else {
                    position = progress;
                }

                timeTable(position);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        timeTable(position);
    }
}
