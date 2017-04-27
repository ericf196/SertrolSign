package com.example.ericfreitez.sertrolsign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin= (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent mainActivity= new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}