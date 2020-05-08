package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddingActivity extends AppCompatActivity {

    TextView tvDay;
    Button btnSubmit;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        // Get the intent
        Intent i = getIntent();
        // Get the Hero object first activity put in Intent
        Grade G = (Grade) i.getSerializableExtra("G");

        tvDay = findViewById(R.id.textViewDay);
        btnSubmit = findViewById(R.id.buttonSubmit);

        tvDay.setText("Week " + G.getWeek());

        rg = findViewById(R.id.rg);

        // When button Like is clicked, set the results
        //  accordingly and finish() to close this act.
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Create intent & pass in String data
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selected);
                Intent i = new Intent();
                i.putExtra("grade", rb.getText().toString());
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // like
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}

