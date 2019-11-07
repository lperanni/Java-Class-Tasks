package org.luciano.app.callback;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttCallbackImpl implements MqttCallback {
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to Mqtt broker lost");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(new String(mqttMessage.getPayload()));
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
