package com.michaelfotiadis.moviedb.core.utils;

import com.michaelfotiadis.moviedb.core.utils.stream.StreamUtils;

import junit.framework.TestCase;

import java.nio.ByteBuffer;

/**
 *
 */
public class StreamUtilsTest extends TestCase {

    public void testByteBufferConversion() throws Exception {

        final String value = "0xE4CFA34A908F6637";

        final ByteBuffer buffer = StreamUtils.convertStringToByteBuffer(value);
        assertNotNull("Null buffer", buffer);
        final String result = StreamUtils.convertByteBufferToString(buffer);

        assertNotNull("Null result", result);
        assertEquals(value, result);

    }

}