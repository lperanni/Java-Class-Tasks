package org.luciano.app.instrument.sensors;


import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Sensor implements Runnable{

    private int min;
    private int max;
    private int factor;
    private int publishTime;
    private String name;
    private String unit;
    private IMqttClient client;

    public Sensor(int min, int max, int factor, String name, String unit, int publishTime) {
        this.min = min * factor;
        this.max = max * factor;
        this.factor = factor;
        this.name = name;
        this.unit = unit;
        this.publishTime = publishTime;
    }

    public Sensor(){};

    public byte[] getMeasure() {
        int val = (int) (Math.random() * ((max - min) + 1)) + min;
        return (val / (factor * factor * 10) + " " + unit + "\n").getBytes();
    }

    @Override
    public void run() {
        MqttMessage message = new MqttMessage(getMeasure());
        try {
            client.publish("Luciano/mjerac/" + name , message);
            Thread.sleep(publishTime);
        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }

    public IMqttClient getClient() {
        return client;
    }

    public void setClient(IMqttClient client) {
        this.client = client;
    }

}
