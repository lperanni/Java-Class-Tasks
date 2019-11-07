package org.luciano.app.instrument;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.luciano.app.instrument.sensors.Sensor;

import java.util.concurrent.Callable;

public class WaterCurrentMeter implements Callable<Void> {

    private IMqttClient client;

    public WaterCurrentMeter(IMqttClient client){
        this.client = client;
    }

    private byte[] readWaterTemp(){
        int min = -32668;
        int max = 32668;
        int factor = 10;

        Sensor temperature = new Sensor(min, max, factor, "Temperature", "C");

        return temperature.getMeasure();

    }

    private byte[] readWaterPressure(){
        int min = 0;
        int max = 65336;
        int factor = 1000;

        Sensor pressure = new Sensor(min, max, factor, "Pressure", "Bar");

        return pressure.getMeasure();

    }

    private byte[] readWaterUsageMinute(){
        int min = 0;
        int max = 65336;

        Sensor usageMinute = new Sensor(min, max, 1, "UsageMinute", "litre");

        return usageMinute.getMeasure();


    }

    private byte[] readWaterUsageWeek(){
        int min = 0;
        int max = 65336;
        int factor = 10;

        Sensor usageYear = new Sensor(min, max, factor, "UsageYear", "Cubic metre");

        return usageYear.getMeasure();
    }

    public Void call() throws Exception {

        if ( !client.isConnected()) {
            return null;
        }
        MqttMessage tempMsg = new MqttMessage(readWaterTemp());
        MqttMessage pressureMsg = new MqttMessage(readWaterPressure());
        MqttMessage minuteUseMsg = new MqttMessage(readWaterUsageMinute());
        MqttMessage weeklyUseMsg = new MqttMessage(readWaterUsageWeek());

        client.publish("Luciano/mjerac/temperatura",tempMsg);
        client.publish("Luciano/mjerac/tlak",pressureMsg);
        client.publish("Luciano/mjerac/potrosnjaMinut", minuteUseMsg);
        client.publish("Luciano/mjerac/potrosnjaTjedan", weeklyUseMsg);


        return null;
    }
}
