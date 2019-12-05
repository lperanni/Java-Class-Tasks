package org.luciano.vjezba4.windows;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.*;
import org.luciano.vjezba4.mqtt.MqttSubscriber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Arrays;

public class MainClientWindow extends JFrame implements MqttCallback {

    JPanel panel;
    JLabel[] messageLabel = new JLabel[4];
    JTextField temp, pressure, usageDay, usageWeek;

    ObjectMapper mapper = new ObjectMapper();
    MqttSubscriber subscriber;
    MqttClient client;

    public MainClientWindow(MqttSubscriber subscriber) throws Exception {
        this.subscriber = subscriber;
        this.client = subscriber.call();
        client.setCallback(this);
        client.connect();
        client.subscribe("#");

        messageLabel[0] = new JLabel("Temperature: ");
        temp = new JTextField();
        temp.setEditable(false);
        messageLabel[1] = new JLabel("Pressure: ");
        pressure = new JTextField();
        pressure.setEditable(false);
        messageLabel[2]  = new JLabel("Usage daily: ");
        usageDay = new JTextField();
        usageDay.setEditable(false);
        messageLabel[3]  = new JLabel("Usage Weekly: ");
        usageWeek = new JTextField();
        usageWeek.setEditable(false);

        panel = new JPanel( new GridLayout(9,3 ));
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel.setBorder(padding);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(messageLabel[0]);
        panel.add(temp);
        panel.add(messageLabel[1]);
        panel.add(pressure);
        panel.add(messageLabel[2]);
        panel.add(usageDay);
        panel.add(messageLabel[3]);
        panel.add(usageWeek);

        add(panel, BorderLayout.CENTER);
        setTitle("Mqtt Client");
        setSize(800, 600);
        setVisible(true);

    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to Broker lost");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        if(s.endsWith("Temperature")){
            temp.setText(mqttMessage.toString());
        }else if(s.endsWith("Pressure")){
            pressure.setText(mqttMessage.toString());
        }
        else if(s.endsWith("UsageMinute")){
            usageDay.setText(mqttMessage.toString());
        }
        else {
            usageWeek.setText(mqttMessage.toString());
        }

    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        try {
            System.out.println("Message successfully delivered" + iMqttDeliveryToken.getMessage());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
