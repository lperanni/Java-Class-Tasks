package org.luciano.vjezba7.service.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.luciano.vjezba7.domain.models.MqttRequest;

public interface IMqttService {
    String publishMessage(MqttRequest request) throws MqttException;
}
