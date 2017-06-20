package io.userfeeds.sdk.signing

import java.math.BigInteger

internal fun byteArrayFromHexString(hex: String): ByteArray = BigInteger(hex, 16).toByteArray()

internal fun ByteArray.toHexString() = joinToString("") { byteToHexMap[it.toInt() and 0xFF] }

private val byteToHexMap by lazy {
    Array<String>(256) { "%02X".format(it) }
}
