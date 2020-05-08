package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModuleDetailsActivity extends AppCompatActivity {

    ListView lv;
    TextView tvWeek, tvGrade;
    ArrayList<Grade> modulesList;
    ArrayAdapter aa;
    Button btnInfo, btnAdd, btnEmail;
    int processing = 1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulegradedisplay);

        Intent i = getIntent();

        lv = findViewById(R.id.gradeDetails);
        tvWeek = findViewById(R.id.textViewWeek);
        tvGrade = findViewById(R.id.textViewGrade);
        btnEmail = findViewById(R.id.btnEmail);
        btnInfo = findViewById(R.id.btnInfo);
        btnAdd = findViewById(R.id.btnAdd);

        modulesList = new ArrayList<Grade>();
        modulesList.add(new Grade(1, "C347", "B"));
        modulesList.add(new Grade(2, "C347", "C"));
        modulesList.add(new Grade(3, "C347", "A"));

        aa = new GradeAdapter(this, R.layout.row, modulesList);
        lv.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Grade G = new Grade(modulesList.size() + 1, "C347","");
                Intent i = new Intent(ModuleDetailsActivity.this, AddingActivity.class);
                i.putExtra("G", G);
                startActivityForResult(i, processing);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity
                String like = data.getStringExtra("grade");
                if (requestCode == processing) {
                    modulesList.add(new Grade(modulesList.size() + 1, "C347", like));
                }
                aa = new GradeAdapter(this, R.layout.row, modulesList);
                lv.setAdapter(aa);
            }
        }
    }
}
