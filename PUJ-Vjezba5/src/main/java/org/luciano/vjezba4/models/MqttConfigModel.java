package org.luciano.vjezba4.models;

public class MqttConfigModel {

    private String broker_protocol;
    private String broker_host;
    private int broker_port;

    public String getBroker_protocol() {
        return broker_protocol;
    }

    public void setBroker_protocol(String broker_protocol) {
        this.broker_protocol = broker_protocol;
    }

    public String getBroker_host() {
        return broker_host;
    }

    public void setBroker_host(String broker_host) {
        this.broker_host = broker_host;
    }

    public int getBroker_port() {
        return broker_port;
    }

    public void setBroker_port(int broker_port) {
        this.broker_port = broker_port;
    }

    public MqttConfigModel(String protocol, String host, int port) {
        this.broker_protocol = protocol;
        this.broker_host = host;
        this.broker_port = port;
    }

    public MqttConfigModel(){}

    public String getBrokerUrl(){
        StringBuilder returnValue = new StringBuilder();
        returnValue.append(broker_protocol);
        returnValue.append("://");
        returnValue.append(broker_host);
        returnValue.append(":");
        returnValue.append(broker_port);

        return returnValue.toString();
    }



}
