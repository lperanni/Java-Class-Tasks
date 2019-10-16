package com.lucianoperanni.vjezba1.Algorithms;

public interface Checksum {

    void update(byte[] b, int start, int length);
    long getValue();
}
