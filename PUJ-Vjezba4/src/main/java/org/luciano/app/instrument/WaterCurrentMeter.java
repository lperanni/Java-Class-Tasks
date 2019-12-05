package org.luciano.app.instrument;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.luciano.app.instrument.sensors.Sensor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

public class WaterCurrentMeter implements Callable<Void> {

    private IMqttClient client;
    private ObjectMapper mapper = new ObjectMapper();
    private Sensor[] sensorArray;

    public WaterCurrentMeter(IMqttClient client, String configPath) throws IOException {
        this.client = client;
        sensorArray = mapper.readValue(new File(configPath), Sensor[].class);
        for(Sensor sensor: sensorArray){
            sensor.setClient(client);
        }
    }

    public Void call() throws Exception {

        if ( !client.isConnected()) {
            return null;
        }
        for(Sensor sensor: sensorArray){
            new Thread(sensor).start();
        }
        return null;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Sensor[] getSensorArray() {
        return sensorArray;
    }

    public void setSensorArray(Sensor[] sensorArray) {
        this.sensorArray = sensorArray;
    }
}
