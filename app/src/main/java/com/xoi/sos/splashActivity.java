package com.xoi.sos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class splashActivity extends AppCompatActivity {

    ImageView logoImg;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoImg = (ImageView)findViewById(R.id.logoImg);
        sp = this.getSharedPreferences("com.xoi.sos",MODE_PRIVATE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String login = sp.getString("login","");
                if (login.equals("1")) {
                    Intent i = new Intent(splashActivity.this, citMain.class);
                    startActivity(i);
                    finish();
                }
                else if(login.equals("2")){
                    Intent i = new Intent(splashActivity.this, govMain.class);
                    startActivity(i);
                    finish();
                }else {
                    Intent i = new Intent(splashActivity.this, loginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 500);
    }
}
