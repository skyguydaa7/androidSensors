package com.lbbento.sensor.playingwithsensors.main;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lbbento.sensor.playingwithsensors.R;

import static android.hardware.Sensor.TYPE_LIGHT;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor lightSensor = sensorManager.getDefaultSensor(TYPE_LIGHT);

        mainActivityPresenter = new MainActivityPresenter(this, sensorManager, lightSensor);
        mainActivityPresenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainActivityPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainActivityPresenter.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        mainActivityPresenter.onSensorChanged(sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}