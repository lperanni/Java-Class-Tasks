package org.luciano.vjezba7.service.implementations;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.luciano.vjezba7.domain.models.MqttRequest;
import org.luciano.vjezba7.service.interfaces.IMqttService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MqttService implements IMqttService, MqttCallback {

    private String returnMessage;

    @Override
    public String publishMessage(MqttRequest request) throws MqttException {
        String publisherId = UUID.randomUUID().toString();
        MqttClient client = new MqttClient(request.getServerUrl(), publisherId, new MemoryPersistence());
        client.setCallback(this);
        client.connect();
        client.publish(request.getTopic(), new MqttMessage(request.getMessage().getBytes()));
        return returnMessage;
    }

    @Override
    public void connectionLost(Throwable throwable) {
        returnMessage = "Connection lost";
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage){
        returnMessage = "Message arrived";
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        returnMessage = "Successfully delivered";
    }
}
