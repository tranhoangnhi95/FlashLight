package com.nn12x3.flashlight;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class WarningActivity extends AppCompatActivity {
    private ImageView txt_Warning1, txtWarning2;
    private Handler handler;
    private Timer timer;
    private int level = 0;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);
        inits();
        controls();
    }

    private void controls() {
        warningLightOn();
    }

    private void warningLightOn() {
        mediaPlayer = MediaPlayer.create(WarningActivity.this,R.raw.warningsound);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                txt_Warning1.setImageLevel(level);
                txtWarning2.setImageLevel(3-level);
                level++;
                level=(level>3)?0:level;
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000,1000);
    }

    private void inits() {
        txt_Warning1 = findViewById(R.id.txt_Warning1);
        txtWarning2 = findViewById(R.id.txt_Warning2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
