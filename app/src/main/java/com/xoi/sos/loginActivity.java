package com.xoi.sos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    String id, pass;
    EditText idTxt, passTxt;
    Button logBut;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idTxt = (EditText)findViewById(R.id.idTxt);
        passTxt = (EditText)findViewById(R.id.passTxt);
        logBut = (Button)findViewById(R.id.logBut);

        sp = this.getSharedPreferences("com.xoi.sos",MODE_PRIVATE);

        logBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = idTxt.getText().toString();
                pass = passTxt.getText().toString();
                checkLogin();
            }
        });
    }

    private void checkLogin(){
        if(id.equals("8310854573") && pass.equals("123")){
            sp.edit().putString("login","1").apply();
            sp.edit().putString("id","8310854573").apply();
            Intent i = new Intent(loginActivity.this, citMain.class);
            startActivity(i);
            finish();
        }else if(id.equals("101") && pass.equals("456")){
            sp.edit().putString("login","2").apply();
            sp.edit().putString("id","101").apply();
            Intent i = new Intent(loginActivity.this, govMain.class);
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(this, "No users found", Toast.LENGTH_SHORT).show();
        }
    }
}
