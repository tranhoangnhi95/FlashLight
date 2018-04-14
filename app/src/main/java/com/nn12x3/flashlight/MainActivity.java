package com.nn12x3.flashlight;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inits();
        controls();
    }

    private void controls() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iMenu = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(iMenu);
                finish();
            }
        },3000);
    }

    private void inits() {
        handler = new Handler();
    }
}
