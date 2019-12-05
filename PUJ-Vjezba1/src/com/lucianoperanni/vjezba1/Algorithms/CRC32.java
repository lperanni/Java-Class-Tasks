package com.lucianoperanni.vjezba1.Algorithms;

public class CRC32 implements Checksum {

    private long returnValue;

    @Override
    public void update(byte[] b, int start, int length) {

        int crc = -1;
        int poly = 0xEDB88320;

        for (int i = 0; i < length; i++) {
            int temp = (crc ^ b[start + i]) & 0xff;

            // read 8 bits, one at a time
            for (int j = 0; j < 8; j++) {
                if ((temp & 1) == 1) {
                    temp = (temp >>> 1) ^ poly;
                } else {
                    temp = (temp >>> 1);
                }
            }
            crc = (crc >>> 8) ^ temp;
        }
        crc = ~crc;
        returnValue = crc & (long) (Math.pow(2, 32) - 1);
    }

    @Override
    public long getValue() {
        return returnValue;

    }
}
