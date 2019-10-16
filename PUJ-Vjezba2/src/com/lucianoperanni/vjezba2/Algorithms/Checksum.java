package com.lucianoperanni.vjezba2.Algorithms;

public interface Checksum {

    void update(byte[] b, int start, int length);
    long getValue();
}
