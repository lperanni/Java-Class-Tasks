package org.luciano.app.instrument.sensors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {

    Sensor sensor;

    @Test
    void getMeasure() {
        sensor = new Sensor(0, 100, 10, "Temperature", "C");
        assertNotNull(sensor);
        assertNotNull(sensor.getMeasure());
    }
}