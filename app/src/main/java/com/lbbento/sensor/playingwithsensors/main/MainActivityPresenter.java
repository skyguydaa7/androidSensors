package com.lbbento.sensor.playingwithsensors.main;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.View;

class MainActivityPresenter {

    private final SensorManager mSensorManager;
    private final Sensor mLightSensor;
    private final MainActivityView view;

    public MainActivityPresenter(final MainActivityView mainActivityView, final SensorManager sensorManager, final Sensor lightSensor) {
        this.view = mainActivityView;
        mLightSensor = lightSensor;
        mSensorManager = sensorManager;
    }

    public void onCreate() {
    }

    public void onSensorChanged(float value) {
        System.out.println(value);
    }

    public void onResume() {
        mSensorManager.registerListener(view, mLightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onPause() {
        mSensorManager.unregisterListener(view);
    }
}
