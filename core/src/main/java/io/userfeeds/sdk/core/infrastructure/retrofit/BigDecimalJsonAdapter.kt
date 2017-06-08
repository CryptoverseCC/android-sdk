package io.userfeeds.sdk.core.infrastructure.retrofit

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.math.BigDecimal

internal class BigDecimalJsonAdapter : JsonAdapter<BigDecimal>() {

    override fun toJson(writer: JsonWriter, value: BigDecimal) {
        writer.value(value.toString())
    }

    override fun fromJson(reader: JsonReader): BigDecimal {
        return BigDecimal(reader.nextString())
    }
}
