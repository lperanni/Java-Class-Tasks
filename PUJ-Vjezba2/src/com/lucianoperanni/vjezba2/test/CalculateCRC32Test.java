package com.lucianoperanni.vjezba2.test;

import com.lucianoperanni.vjezba2.Algorithms.CRC32;

public class CalculateCRC32Test {
    public static void main(String[] args){

        String toTest = "Ovo je test za vlastitu CRC32 klasu";
        int toTestInt = 98;

        byte[] toTestByteArray = toTest.getBytes();

        CRC32 checksum = new CRC32();

        checksum.update(toTestByteArray);
        System.out.println("Checksum.update(byte[] b) called.");
        System.out.println("Value of checksum is: " + checksum.getValue());

        checksum.reset();
        System.out.println("Checksum.reset() called.");
        System.out.println("Value of checksum is: " + checksum.getValue());

        checksum.update(toTestInt);
        System.out.println("Checksum.update(int b) called.");
        System.out.println("Value of checksum is: " + checksum.getValue());

        checksum.reset();
        System.out.println("Checksum.reset() called.");
        System.out.println("Value of checksum is: " + checksum.getValue());

        checksum.update(toTestByteArray, 0, toTestByteArray.length);
        System.out.println("Checksum.update(byte[] b) called.");
        System.out.println("Value of checksum is: " + checksum.getValue());

    }
}
