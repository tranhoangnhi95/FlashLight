package com.nn12x3.flashlight;

import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Parameter;
import java.util.Timer;
import java.util.TimerTask;

public class LightActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private ToggleButton btn_SwitchLight;
    private android.hardware.Camera camera;
    private android.hardware.Camera.Parameters parameter;
    private  boolean deviceHasFlash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        inits();
        controls();
    }

    private void controls() {
        checkFlash();

        btn_SwitchLight.setOnCheckedChangeListener(this);
    }

    private void checkFlash() {
        deviceHasFlash = getApplication().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (!deviceHasFlash){
            Toast.makeText(LightActivity.this, "Sorry, your device does not have any flash", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void inits() {
        btn_SwitchLight = findViewById(R.id.btn_SwitchLight);
        this.camera = android.hardware.Camera.open(0);
        if (this.camera != null) {
            parameter = this.camera.getParameters();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.btn_SwitchLight:
                SwitchLight();
        }
    }

    private void SwitchLight() {

        if (btn_SwitchLight.isChecked()) {

            turnOnTheFlash();
        }
        else{
            turnOffTheFlash();
        }
    }

    private void turnOffTheFlash() {
        parameter.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_OFF);
        this.camera.setParameters(parameter);
        this.camera.stopPreview();
    }
    private void turnOnTheFlash() {
        if(this.camera != null) {
            parameter.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
            this.camera.setParameters(parameter);
            this.camera.startPreview();
        }
    }

    private void getCamera(){
        if (camera == null){
            try{
                camera = android.hardware.Camera.open();
                parameter = camera.getParameters();
            }
            catch (RuntimeException e){
                System.out.println("Error: Failed to Open: " + e.getMessage());
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(this.camera != null){
            this.camera.release();
            this.camera = null;
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getCamera();
    }
}
