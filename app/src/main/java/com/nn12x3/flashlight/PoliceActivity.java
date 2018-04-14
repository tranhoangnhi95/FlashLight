package com.nn12x3.flashlight;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class PoliceActivity extends AppCompatActivity {
    private ImageView txt_Police;
    private Handler handler;
    private Timer timer;
    private int level = 0;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);
        inits();
        controls();
    }

    private void controls() {
        PoliceModeActive();
    }

    private void PoliceModeActive() {
        mediaPlayer = MediaPlayer.create(PoliceActivity.this,R.raw.policesound);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                level++;
                txt_Police.setImageLevel(level);
                if (level == 7){
                    level = 0;
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },100,100);
    }

    private void inits() {
        txt_Police = findViewById(R.id.txt_Police);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
