package com.xoi.sos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class finalActivity extends AppCompatActivity {
   Toolbar toolbar;
   TextView tvAlertloc,tv3;
   ImageView ivSent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String alertloc=getIntent().getExtras().getString("latlang");
        tvAlertloc=(TextView)findViewById(R.id.tvAlertloc);
        tv3=(TextView)findViewById(R.id.textView3);
        ivSent=(ImageView)findViewById(R.id.ivSent);
        int i=alertloc.indexOf("(");
        i=i+1;
        int j=alertloc.indexOf(",");
        int k=alertloc.lastIndexOf(")");
        ivSent.animate().scaleXBy(1.5f).scaleYBy(1.5f).setDuration(500);
        String lat=alertloc.substring(i,j);
        j=j+1;
        String lang=alertloc.substring(j,k);
        tvAlertloc.setText(lat);
        tv3.setText(lang);

    }
}
