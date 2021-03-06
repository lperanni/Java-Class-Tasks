package org.luciano.vjezba4;

import org.luciano.vjezba4.mqtt.MqttSubscriber;
import org.luciano.vjezba4.windows.MainClientWindow;

public class MqttClientApplication {


    public static void main(String[] args) {

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
