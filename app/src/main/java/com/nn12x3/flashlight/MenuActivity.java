package com.nn12x3.flashlight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton btn_Light, btn_Screen, btn_Police, btn_Traffic, btn_Warning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        inits();
        controls();
    }

    private void controls() {
        btn_Light.setOnClickListener(this);
        btn_Screen.setOnClickListener(this);
        btn_Police.setOnClickListener(this);
        btn_Traffic.setOnClickListener(this);
        btn_Warning.setOnClickListener(this);
    }

    private void inits() {
        btn_Light = findViewById(R.id.btn_Light);
        btn_Screen = findViewById(R.id.btn_Screen);
        btn_Police = findViewById(R.id.btn_Police);
        btn_Traffic = findViewById(R.id.btn_Traffic);
        btn_Warning = findViewById(R.id.btn_Warning);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Light:
                Intent iLight = new Intent(MenuActivity.this,LightActivity.class);
                startActivity(iLight);
                break;
            case R.id.btn_Screen:
                Intent iScreen = new Intent(MenuActivity.this, ScreenActivity.class);
                startActivity(iScreen);
                break;
            case R.id.btn_Police:
                Intent iPolice = new Intent(MenuActivity.this, PoliceActivity.class);
                startActivity(iPolice);
                break;
            case R.id.btn_Traffic:
                Intent iTraffic = new Intent(MenuActivity.this,TrafficActivity.class);
                startActivity(iTraffic);
                break;
            case R.id.btn_Warning:
                Intent iWarning = new Intent(MenuActivity.this,WarningActivity.class);
                startActivity(iWarning);
                break;
        }
    }
}
