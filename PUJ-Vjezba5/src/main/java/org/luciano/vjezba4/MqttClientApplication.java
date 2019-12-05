package org.luciano.vjezba4;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.luciano.vjezba4.models.MqttConfigModel;
import org.luciano.vjezba4.mqtt.MqttSubscriber;
import org.luciano.vjezba4.windows.MainClientWindow;

import java.io.IOException;

public class MqttClientApplication {


    public static void main(String[] args) throws IOException {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainClientWindow(new MqttSubscriber());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
