package com.nn12x3.flashlight;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class TrafficActivity extends AppCompatActivity {
    private ImageView txt_Traffic;
    private Button btn_Timer;
    private Handler handler;
    private Timer timer;
    private  int level = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);
        inits();
        controls();
    }

    private void inits() {
        txt_Traffic = findViewById(R.id.txt_Traffic);
        btn_Timer = findViewById(R.id.btn_Timer);
    }

    private void controls() {
        btn_Timer.setBackground(getResources().getDrawable(R.drawable.radius_button_black));
        startTrafficLight();
    }

    private void startTrafficLight() {
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                txt_Traffic.setImageLevel(level);
                if (level >= 0 && level <= 10){
                    btn_Timer.setTextColor(getResources().getColor(R.color.timer_green));
                    btn_Timer.setText(String.valueOf(10-level));
                    btn_Timer.setBackground(getResources().getDrawable(R.drawable.radius_button_green));
                }
                else if (level >= 11 && level <= 13 ){
                    btn_Timer.setTextColor(getResources().getColor(R.color.timer_yellow));
                    btn_Timer.setText(String.valueOf(13-level));
                    btn_Timer.setBackground(getResources().getDrawable(R.drawable.radius_button_yellow));
                }
                else {
                    btn_Timer.setTextColor(getResources().getColor(R.color.timer_red));
                    btn_Timer.setText(String.valueOf(20-level));
                    btn_Timer.setBackground(getResources().getDrawable(R.drawable.radius_button_red));
                }
                level++;
                level=(level>20)?0:level;
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
}
