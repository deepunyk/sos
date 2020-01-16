package com.xoi.sos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;

public class govMain extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout aLayout, pLayout, hLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gov_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        aLayout = (LinearLayout)findViewById(R.id.alertLayout);
        pLayout = (LinearLayout)findViewById(R.id.personnelLayout);
        hLayout = (LinearLayout)findViewById(R.id.historyLayout);

        aLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(govMain.this, alertActivity.class);
                startActivity(i);
                finish();
            }
        });

        pLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(govMain.this, personnelActivity.class);
                startActivity(i);
                finish();
            }
        });
        hLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(govMain.this, historyActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
