package com.lucianoperanni.vjezba2.test;

import com.lucianoperanni.vjezba2.Algorithms.CRC32;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CRC32Test {

    private static CRC32 checksum;

    @BeforeAll
    static void setUp() {
        checksum = new CRC32();
    }

    @ParameterizedTest
    @ValueSource(ints = 98)
    void update(int b) {

        checksum.update(b);
        Assert.assertEquals(1908338681L, checksum.getValue());
        checksum.reset();
    }

    @Test
    void getValue() {
        Assert.assertEquals(0, checksum.getValue());
    }

    @Test
    void reset() {
        checksum.update(6);
        checksum.reset();
        Assert.assertEquals(0,checksum.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = "Ovo je test za klasu")
    void testUpdate(String toTest) {
        byte[] toTestByteArray = toTest.getBytes();
        checksum.update(toTestByteArray);
        Assert.assertEquals(3627047606L, checksum.getValue());
        checksum.reset();
    }

    @Test
    void testUpdate1() {
        int start = 0;
        String str = "Generate CRC32 Checksum For Byte Array Example";
        byte[] bytes = str.getBytes();
        checksum.update(bytes, start, bytes.length);
        Assert.assertEquals(3510043186L, checksum.getValue());

    }
}