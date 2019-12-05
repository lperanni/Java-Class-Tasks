package org.luciano.vjezba4.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.luciano.vjezba4.models.MqttConfigModel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

public class MqttSubscriber implements Callable<MqttClient> {

    private String brokerUrl;
    private MqttClient client;
    ObjectMapper mapper = new ObjectMapper();
    MqttConfigModel model;


    public MqttSubscriber() throws IOException {

        model = mapper.readValue(new File("src/main/resources/appConfig.json"), MqttConfigModel.class);
        brokerUrl = model.getBrokerUrl();
    }

    public MqttClient call() throws Exception {

        try {
            client = new MqttClient(brokerUrl, MqttClient.generateClientId());


        } catch (MqttException e) {
            e.printStackTrace();
        }
        return client;
    }

}
