package com.lbbento.sensor.playingwithsensors.main;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static android.hardware.SensorManager.SENSOR_DELAY_NORMAL;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    @Mock
    private MainActivityView mainActivityView;

    @Mock
    private SensorManager sensorManager;

    @Mock
    private Sensor lightSensor;

    private MainActivityPresenter mainActivityPresenter;

    @Before
    public void setup() {
        mainActivityPresenter = new MainActivityPresenter(mainActivityView, sensorManager, lightSensor);
    }

    @Test
    public void shouldRegisterSensorsListener_OnResume() {
        mainActivityPresenter.onResume();

        verify(sensorManager).registerListener(mainActivityView, lightSensor, SENSOR_DELAY_NORMAL);
    }

    @Test
    public void shouldDeregisterSensorListener_onPause() {
        mainActivityPresenter.onPause();

        sensorManager.unregisterListener(mainActivityView);
    }

}