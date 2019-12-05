package com.lucianoperanni.vjezba2.Algorithms;

public class CRC32 implements Checksum {

    private long returnValue = 0;
    private int crc = -1;

    @Override
    public void update(byte[] b, int start, int length) {

        for (byte i: b) {
            int temp = (crc ^ i) & 0xff;

            calcCRC(temp);
        }
        crc = ~crc;
        returnValue = crc & (long) (Math.pow(2, 32) - 1);
    }

    @Override
    public long getValue() {
        return returnValue;

    }

    @Override
    public void reset() {
        crc = -1;
        returnValue = 0;
    }

    public void update(byte[] b){

        for (byte i: b) {
            int temp = (crc ^ i) & 0xff;

            calcCRC(temp);
        }
        crc = ~crc;
        returnValue = crc & (long) (Math.pow(2, 32) - 1);
    }

    @Override
    public void update(int b) {

        byte arr = (byte) (b & 0xFF);

        int temp = (crc ^ arr) & 0xff;

        calcCRC(temp);

        crc = ~crc;
        returnValue = crc & (long) (Math.pow(2, 32) - 1);
    }

    private void calcCRC(int temp) {

        // read 8 bits, one at a time
        for (int j = 0; j < 8; j++) {
            if ((temp & 1) == 1) {
                int poly = 0xEDB88320;
                temp = (temp >>> 1) ^ poly;
            } else {
                temp = (temp >>> 1);
            }
        }
        crc = (crc >>> 8) ^ temp;
    }
}
