package com.nn12x3.flashlight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ToggleButton;

public class ScreenActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private FrameLayout fl_Screen;
    private ToggleButton btn_SwitchScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        inits();
        controls();
    }

    private void controls() {
        btn_SwitchScreen.setOnCheckedChangeListener(this);
    }

    private void inits() {
        fl_Screen = findViewById(R.id.fl_Sreen);
        btn_SwitchScreen = findViewById(R.id.btn_SwitchScreen);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.btn_SwitchScreen:
                if (btn_SwitchScreen.isChecked()){
                    fl_Screen.setVisibility(View.VISIBLE);
                }
                else {
                    fl_Screen.setVisibility(View.INVISIBLE);
                }
        }
    }
}
