package com.example.naveen.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.util.Log;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar baseNumber = findViewById(R.id.baseNumber);
        final ListView numberTable = findViewById(R.id.numberTable);
        final ArrayList<Integer> table = new ArrayList<Integer>();

        baseNumber.setMax(19);

        baseNumber.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progressValue = 1;
                if (!(table.isEmpty())) {
                    table.clear();
                }
                progressValue = progressValue + progress;
                Log.i("Number: ", Integer.toString(progressValue));
                for (int i = 1; i <= 20; i++) {
                    table.add(progressValue * i);
                }
                ArrayAdapter<Integer> tableAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, table);
                numberTable.setAdapter(tableAdapter);

            }
        });
    }
}
