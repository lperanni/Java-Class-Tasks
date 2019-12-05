package org.luciano.app.instrument.sensors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {

    @Test
    void getMeasure() {
        Sensor sensor = new Sensor(0, 100, 10, "Temperature", "C", 4000);
        assertNotNull(sensor);
        assertNotNull(sensor.getMeasure());
    }
}