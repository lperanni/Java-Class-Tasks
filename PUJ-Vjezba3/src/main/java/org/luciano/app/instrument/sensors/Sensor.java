package org.luciano.app.instrument.sensors;


public class Sensor {

    private int min;
    private int max;
    private int factor;
    private String name;
    private String unit;

    public Sensor(int min, int max, int factor, String name, String unit) {
        this.min = min * factor;
        this.max = max * factor;
        this.factor = factor;
        this.name = name;
        this.unit = unit;
    }

    public byte[] getMeasure() {
        int val = (int) (Math.random() * ((max - min) + 1)) + min;
        return (name + " " + val / (factor * factor) + " " + unit + "\n").getBytes();
    }


}
