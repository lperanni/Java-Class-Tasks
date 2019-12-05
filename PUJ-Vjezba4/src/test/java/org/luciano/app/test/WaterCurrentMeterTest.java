package org.luciano.app.test;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.luciano.app.instrument.WaterCurrentMeter;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class WaterCurrentMeterTest {

    IMqttClient client;
    @BeforeEach
    void setUp() throws MqttException {
        client = new MqttClient("tcp://localhost:1883", UUID.randomUUID().toString());
    }

    @Test
    void call() throws IOException {
        WaterCurrentMeter meter = new WaterCurrentMeter(client, "src/main/resources/SensorConfig.json");
        assertNotNull(meter);
        assertNotNull(meter.getSensorArray());
        assertNotNull(meter.getMapper());
    }
}