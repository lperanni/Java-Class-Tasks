package org.luciano.app;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.luciano.app.callback.MqttCallbackImpl;
import org.luciano.app.instrument.WaterCurrentMeter;
import java.util.UUID;

public class MqttApplication {
    public static void main(String[] args) throws Exception {

        String publisherId = UUID.randomUUID().toString();
        IMqttClient publisher = new MqttClient("tcp://localhost:1883", publisherId);
        String path = "src/main/resources/SensorConfig.json";

        publisher.setCallback(new MqttCallbackImpl());
        publisher.connect();

        WaterCurrentMeter meter = new WaterCurrentMeter(publisher, path);

        while (true){
            Thread.sleep(10000);
            meter.call();
        }




    }
}
