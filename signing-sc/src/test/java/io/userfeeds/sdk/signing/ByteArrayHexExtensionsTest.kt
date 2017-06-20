package io.userfeeds.sdk.signing

import org.junit.Assert.*
import org.junit.Test

class ByteArrayHexExtensionsTest {

    @Test
    fun shouldDecodeFromHexString() {
        assertArrayEquals(byteArrayOf(0x00, 0xC0.toByte(), 0x20), byteArrayFromHexString("00C020"))
    }

    @Test
    fun shouldEncodeToHexString() {
        assertEquals("00C020", byteArrayOf(0x00, 0xC0.toByte(), 0x20).toHexString())
    }
}
