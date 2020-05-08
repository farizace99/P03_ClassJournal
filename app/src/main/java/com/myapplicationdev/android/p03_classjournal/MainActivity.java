package com.myapplicationdev.android.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int requestCodeForC347 = 1;

    ListView lv;
    ArrayList<Module> modulesList;
    ArrayAdapter module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvModuleCode);

        modulesList = new ArrayList<Module>();
        modulesList.add(new Module("C347"));

        module = new ModuleAdapter(this, R.layout.activity_row, modulesList);
        lv.setAdapter(module);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(MainActivity.this, ModuleDetailsActivity.class);
                startActivity(i);
            }
        });


    }
}
