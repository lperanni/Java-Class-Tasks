package com.lucianoperanni.vjezba1;

/*
Generate CRC32 Checksum For Byte Array Example
This Java example shows how to get the CRC32 checksum value for
array of bytes using CRC32 Java class.

Value = 3510043186
*/

//import java.util.zip.CRC32;
//import java.util.zip.Checksum;


import com.lucianoperanni.vjezba1.Algorithms.CRC32;
import com.lucianoperanni.vjezba1.Algorithms.Checksum;

public class CalculateCRC32ForByteArray {

    public static void main(String[] args){

        String str = "Generate CRC32 Checksum For Byte Array Example";

        //Convert string to bytes
        byte[] bytes = str.getBytes();

        Checksum checksum = new CRC32();

        /*
         * To compute the CRC32 checksum for byte array, use
         *
         * void update(bytes[] b, int start, int length)
         * method of CRC32 class.
         */

        checksum.update(bytes,0,bytes.length);

        /*
         * Get the generated checksum using
         * getValue method of CRC32 class.
         */
        long lngChecksum = checksum.getValue();

        System.out.println("CRC32 checksum for byte array is:" + lngChecksum);
    }
}
/*
Output of this program would be
CRC32 checksum for byte array is :3510043186
*/